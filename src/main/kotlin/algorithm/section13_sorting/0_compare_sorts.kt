package algorithm.section13_sorting

fun main() {
    println("--------------------")
    bubbleSort(list())
    println("--------------------")
    selectionSort(list())
    println("--------------------")
    insertionSort(list())
    println("--------------------")
    mergeSort(list())
    println("--------------------")
}

private fun list(): MutableList<Int> {
    return mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0) // original list
//    return mutableListOf(99, 63, 6, 4, 1, 283, 44, 87, 5, 2, 0) // shuffle original
//    return mutableListOf(283, 44, 87, 2, 0, 5, 63, 6, 99, 1, 4) // shuffle original
//    return almostSortedList() // Almost sorted list
//    return mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9) // sorted list
//    return mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1) // reversed list
}

private fun almostSortedList(): MutableList<Int> {
    return mutableListOf(2, 0, 1, 5, 63, 4, 6, 44, 87, 99, 283)
}