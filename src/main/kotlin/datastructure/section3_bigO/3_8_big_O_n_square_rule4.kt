@file:Suppress("SameParameterValue")

package datastructure.section3_bigO

/**
 * What's the Big O?
 *
 * We have O(n + n^2)
 *
 * Rule 4 says to drop the non dominants
 *
 * So Big O is :: _**O(n^2)**_
 */

fun main() {
    logAllPairs(list)
//    logUniquePairs(list)
}

private val list = arrayOf(1,2,3,4,5)

private fun logAllPairs(list: Array<Int>) {
    println("These are the numbers")
    list.forEach {// O(n)
        println(it)
    }

    println("And these are their sums")
    list.forEach { firstNumber -> // O(n^2)
        list.forEach { secondNumber ->
            println(firstNumber + secondNumber)
        }
    }
}