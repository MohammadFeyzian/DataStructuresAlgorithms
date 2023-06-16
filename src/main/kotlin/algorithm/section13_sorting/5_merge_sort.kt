package algorithm.section13_sorting

/**
 * Merge sort is one of the efficient algorithms which is a good option
 * when we come with the large set of data.
 *
 * In this algorithm, we try to concur and divide the list into the small pieces
 * until each list has one item and then try to merge the lists together
 * one with the another one in a sorted way.
 *
 * The point here is that when we have left and right lists, we know that the
 * right and left ones are sorted and we just need to compare them once
 * and no need to compare all of them together.
 *
 * Start splitting the list:
 *
 * [4, 3, 2, 1]
 *
 * [4, 3] - [2, 1]
 *
 * [4] - [3] - [2] - [1]
 *
 * start merging in a sorted way:
 *
 * [3, 4] - [1, 2]
 *
 * [1, 2, 3, 4]
 */
fun main() {
    val list = mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)

    println(mergeSort(list))
}

private var operation = 0

fun mergeSort(list: MutableList<Int>): MutableList<Int> {
    operation = 0
    val sortedList = splitAndMergeToSort(list)
    println("Number of operations for merge sort is: $operation")
    return sortedList
}

private fun splitAndMergeToSort(list: MutableList<Int>): MutableList<Int> {
    if (list.size < 2) {
        return list
    }
    val middle = list.size.div(2)
    val left = mutableListOf<Int>().apply { addAll(list.subList(0, middle)) }
    val right = mutableListOf<Int>().apply { addAll(list.subList(middle, list.size)) }

    return merge(
        splitAndMergeToSort(left),
        splitAndMergeToSort(right)
    )
}

private fun merge(
    left: MutableList<Int>,
    right: MutableList<Int>
): MutableList<Int> {
    val list = arrayListOf<Int>()
    while (left.size > 0 || right.size > 0) {
        operation++
        if (right.size == 0 || (left.size > 0 && left.first() <= right.first())) {
            list.add(left.first())
            left.removeFirst()
        } else {
            list.add(right.first())
            right.removeFirst()
        }
    }
    return list
}