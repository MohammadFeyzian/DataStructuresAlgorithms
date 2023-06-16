@file:Suppress("unused", "SameParameterValue", "UNUSED_PARAMETER")

package datastructure.section3_bigO

/**
 * This is the _**Quadratic Time**_ notation.
 *
 * When we see loops in a row, we use plus (+) for Big O
 *
 * But, when we see nested loops, we use multiplication (*)
 *
 * In this case Big O is O(n * n) which is O(n^2)
 *
 * This can grow up like _**O(n^x)**_
 *
 * For different inputs like [logAllPairsDifferentInputs] we use the * directly
 *
 * for [logAllPairsDifferentInputs] Big O is: O(a*b)
 */

fun main() {
    logAllPairs(list)
//    logUniquePairs(list)
}

private val list = arrayOf("a", "b", "c", "d", "e")

private fun logAllPairs(list: Array<String>) {
    list.forEach { parentValue -> // O(n)
        list.forEach { childValue -> // O(n)
            println("$parentValue, $childValue")
        }
    }
}

private fun logUniquePairs(list: Array<String>) {
    list.forEachIndexed { parentIndex, parentValue ->
        list.drop(parentIndex + 1).forEach { childValue ->
            println("$parentValue, $childValue")
        }
    }
}

private fun logAllPairsDifferentInputs(list1: Array<String>, list2: Array<String>) {
    list.forEach { parentValue -> // O(a)
        list2.forEach { childValue -> // O(b)
            println("$parentValue, $childValue")
        }
    }
}