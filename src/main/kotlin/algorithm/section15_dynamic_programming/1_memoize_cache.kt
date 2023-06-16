package algorithm.section15_dynamic_programming

/**
 * In some cases we have one operation which is happening multiple times
 * ,and it is doing the same thing.
 *
 * To optimize the operation and preventing some redundant operations,
 * we can cache the result and return it in the same situations.
 */
fun main() {

    val memoizeAdd = MemoizeAdd()

    println(memoizeAdd.addTo80(5))
    println(memoizeAdd.addTo80(5))
    println(memoizeAdd.addTo80(5))
    println(memoizeAdd.addTo80(4))
    println(memoizeAdd.addTo80(2))
    println(memoizeAdd.addTo80(5))
}

private class MemoizeAdd {
    val cache = mutableMapOf<Int, Int>()

    fun addTo80(n: Int): Int {
        return memoizeAddTo80(n)
    }

    private fun memoizeAddTo80(n: Int): Int {
        return if (cache.contains(n)) {
            println("Cacheing")
            cache[n]!!
        } else {
            println("Long operation is happening")
            val operation = n + 80
            cache[n] = operation
            operation
        }
    }
}