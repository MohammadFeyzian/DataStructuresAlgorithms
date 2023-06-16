package algorithm.section13_sorting

/**
 * Selection sort algorithm grab the first item and compare it to the rest of the items
 * and if find a smaller item, grab that one and do the comparison until the end of the list.
 * Then it replace the found smallest one with the start point.
 *
 * Because we have 2 nested loops, the time complexity is O(n&2)
 *
 * The space complexity will is O(1)
 */

fun main() {
    val list = mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)

    println(selectionSort(list))
}

fun selectionSort(list: MutableList<Int>): MutableList<Int> {
    var startIndex = 0
    var operation = 0
    while (startIndex < list.size) {
        var counter = startIndex
        var minIndex = startIndex
        while (counter < list.size) {
            operation++
            if (list[minIndex] > list[counter]) {
                minIndex = counter
            }
            counter++
        }
        // Swap the founded min with the started item
        val temp = list[startIndex]
        list[startIndex] = list[minIndex]
        list[minIndex] = temp
        startIndex++
    }

    println("Number of operations for selection sort is: $operation")
    return list
}