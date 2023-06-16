package algorithm.section13_sorting

/**
 * Bubble sort algorithm looks at 2 items and compare them together and go to the
 * next item: 1<->2, 2<->3, 3<->4...
 *
 * This algorithm compare the first item with the next item and if first item is
 * grater than the second item, it swap them and repeat this until the list is sorted.
 *
 * Because we have 2 nested loops, the time complexity is O(n&2)
 *
 * The space complexity will is O(1)
 */
fun main() {
    val list = mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)

    println(bubbleSort(list))
}

fun bubbleSort(list: MutableList<Int>): MutableList<Int> {
    var maxLoop = list.size - 1
    var operation = 0
    while (maxLoop > 0) {
        var counter = 0
        while (counter < maxLoop) {
            operation++
            if (list[counter] > list[counter + 1]) {
                // Swap numbers
                val temp = list[counter]
                list[counter] = list[counter + 1]
                list[counter + 1] = temp
            }
            counter++
        }
        maxLoop--
    }
    println("Number of operations for bubble sort is: $operation")
    return list
}