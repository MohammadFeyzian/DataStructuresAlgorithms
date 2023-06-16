@file:Suppress("unused", "UNUSED_VARIABLE")

package datastructure.section4_solve_problmes

import common.endPrint
import common.startPrint

/**
 * Given 2 arrays, create a function that let's a user know (true/ false)
 * whether these two arrays contain any common items
 *
 * For Example:
 *
 * const array1 = ['a', 'b', 'c', 'x']
 *
 * const array2 = ['z', 'y', 'i']
 *
 * should return false
 */

fun main() {

    val list1: List<Int> = arrayListOf<Int>().apply {
        for (i in 1..1000_000) {
            add(i)
        }
    }
    val list2: List<Int> = arrayListOf<Int>().apply {
        for (i in 2000_000 downTo 1000_001) {
            add(i)
        }
    }

    val list3: List<Int> = arrayListOf<Int>().apply {
        for (i in 2000_000 downTo 999_996) {
            add(i)
        }
    }

    println("Do lists have common items? ${checkIfThereIsACommonItemsBetterSolution(list1, list2)}")
}

private fun checkIfThereIsACommonItemsBetterSolution(list1: List<Int>, list2: List<Int>): Boolean {
    startPrint()
    var operations: Long = 0
    var haveCommon = false
    val startTime = System.currentTimeMillis()
    val map = mutableMapOf<Int, Boolean>()
    for (item in list1) {
        operations++
        if (map[item] != true) {
            map[item] = true
        }
    }
    for (item in list2) {
        operations++
        if (map[item] == true) {
            haveCommon = true
            break
        }
    }
    val endTime = System.currentTimeMillis()
    endPrint(operations, startTime, endTime)
    return haveCommon
}

private fun checkIfThereIsACommonItemsWorstSolution(list1: List<Int>, list2: List<Int>): Boolean {
    startPrint()
    var operations: Long = 0
    var haveCommon = false
    val startTime = System.currentTimeMillis()
    outerLoop@ for (item1 in list1) {
        innerLoop@ for (item2 in list2) {
            operations++
            if (item1 == item2) {
                haveCommon = true
                break@outerLoop
            }
        }
    }
    val endTime = System.currentTimeMillis()
    endPrint(operations, startTime, endTime)
    return haveCommon
}