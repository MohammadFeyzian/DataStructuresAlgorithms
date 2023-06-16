package datastructure.section7_hash_tables

/**
 * This class does not support collision
 * This means, when a key is added with the same hash code, that key will be replaced
 */

fun main() {

    val hashTable = SimpleHashTable(50)

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

}

class SimpleHashTable(size: Int) {

    private val data: Array<Array<Any>>

    init {
        this.data = Array(size) {
            Array(2) {}
        }
    }

    operator fun set(key: String, value: Any) {
        val address = hash(key)
        data[address] = arrayOf(key, value)
    }

    operator fun get(key: String): Any {
        val address = hash(key)
        return data[address][1]
    }

    /**
     * Create a hash code for the key
     * This code can be the same for some keys which leads to collision
     */
    private fun hash(key: String): Int {
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
            data.forEachIndexed { index, array ->
                if (array[0] !is Unit) {
                    if (index > 0) {
                        append(", ")
                    }
                    append("${array[0]}=${array[1]}")
                }
            }
            append("}")
        }
        return builder.toString()
    }
}