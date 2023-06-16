package datastructure.section7_hash_tables

/**
 * This class support collision which means if the has code is the same for 2 keys
 * those items will be store in the same bucket.
 */

fun main() {

    val hashTable = HashTable<Int>(50)

    hashTable["First key"] = 10
    hashTable["Second key"] = 20
    hashTable["Third key"] = 30
    hashTable["Forth key"] = 40
    hashTable["Fifth key"] = 50
    hashTable["Sixth key"] = 60

    println()
    println("Before collision: $hashTable")

    // hash code will be the same as "Third key", so collision happens here and it override the Third key's value
    hashTable["Seventh key"] = 70

    println()
    println("After collision: $hashTable")

    println()
    println("First key: ${hashTable["First key"]}")
    println("Second key: ${hashTable["Second key"]}")
    println("Third key: ${hashTable["Third key"]}")
    println("Forth key: ${hashTable["Forth key"]}")
    println("Fifth key: ${hashTable["Fifth key"]}")
    println("Sixth key: ${hashTable["Sixth key"]}")
    println("Seventh key: ${hashTable["Seventh key"]}")

    println()
    println("Keys: ${hashTable.keys()}")
}

class HashTable<V>(size: Int) {

    // Add ArrayList as the item for the data to handle the collision
    private val data: Array<ArrayList<Pair<String, V>>>

    init {
        this.data = Array(size) {
            arrayListOf()
        }
    }

    operator fun set(key: String, value: V) { // O(1)
        val address = hash(key)
        data[address].add(Pair(key, value)) // Adding more items to the same address with using ArrayList fix the collision
    }

    operator fun get(key: String): V? { // O(1)
        val address = hash(key)
        val currentBucket = data[address]
        if (currentBucket.isNotEmpty()) {
            return currentBucket.firstOrNull { pair ->
                pair.first == key
            }?.second
        }
        return null
    }

    fun keys(): List<String> {
        val keys = arrayListOf<String>()
        data.forEach { bucket ->
            bucket.forEach { pair ->
                keys.add(pair.first)
            }
        }
        return keys
    }

    /**
     * Create a hash code for the key
     * This code can be the same for some keys which lead to collision
     */
    private fun hash(key: String): Int { // O(1)
        var hash = 0
        key.forEachIndexed { index, char ->
            hash = (hash + char.code * index) % data.size
        }
        return hash
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.apply {
            append("{")
            data.forEachIndexed { outerIndex, currentBucket ->
                if (currentBucket.isNotEmpty()) {
                    if (outerIndex > 0) {
                        append(", ")
                    }
                    if (currentBucket.size > 1) {
                        append("{")
                        currentBucket.forEachIndexed { innerIndex, pair ->
                            if (innerIndex > 0) {
                                append(", ")
                            }
                            append("${pair.first}=${pair.second}")
                        }
                        append("}")
                    } else {
                        val pair = currentBucket.first()
                        append("${pair.first}=${pair.second}")
                    }
                }
            }
            append("}")
        }
        return builder.toString()
    }
}