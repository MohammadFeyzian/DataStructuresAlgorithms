@file:Suppress("SameParameterValue")

package datastructure.section3_bigO

/**
 * This is the _**O(n) - Linear Time**_ notation which means it took n time to operate the worst case scenario,
 * and when input gets bigger, the number of operations also gets bigger
 */

fun main() {
    findNemo(largeList, "nemo999999") // O(n)
}

private val largeList = arrayListOf<String>().apply {
    repeat(1_000_000) {
        add("nemo$it")
    }
}

private fun findNemo(list: List<String>, target: String) {
    var operationCount = 0
    for (name in list) {
        operationCount++
        if (name == target) {
            println("Found TARGET!")
        }
    }
    print("Operations took $operationCount times")
}