@file:Suppress("UNUSED_VARIABLE")

package datastructure.section4_solve_problmes

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

    println("Do lists have common items? ${checkIfThereIsACommonItemsBetterSolution(list2, list3)}")
}

private fun checkIfThereIsACommonItemsBetterSolution(list1: List<Int>, list2: List<Int>): Boolean {
    val map = mutableMapOf<Int, Boolean>()
    list1.forEach { item ->
        if (map[item] != true) {
            map[item] = true
        }
    }
    val commonItem = list2.firstOrNull { item ->
        map[item] == true
    }
    return commonItem != null
}