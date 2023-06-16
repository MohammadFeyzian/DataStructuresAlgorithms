@file:Suppress("SameParameterValue")

package datastructure.section3_bigO

/**
 * This is the _**O(1) - Constant Time**_ notation which means it always took a constant number
 * of operations to perform the function regardless of the input. The important point is that
 * We don't care about number of operations and we always call it O(1)
 */

fun main() {
    findNemo(largeList) // O(2) -> which means -> O(1)
}

private val largeList = arrayListOf<String>().apply {
    repeat(1_000_000) {
        add("Name$it")
    }
}

private fun findNemo(list: List<String>) {
    println("First item is ${list[0]}") // O(1)
    println("First item is ${list[1]}") // O(1)
}