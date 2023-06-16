package algorithm.section13_sorting

/**
 * Insertion algorithm is an algorithm which start from the beginning of the list
 * and compare the item with the previous ones and and when it find the correct
 * position, it will add the targeted one.
 *
 * Insertion sort normally is a good option when we have a small data list
 * or we have an almost sorted list.
 *
 * In general, the Big O for insertion sort is O(n^2), but when list is
 * almost sorted it could be O(n)
 */
fun main() {

    val list = mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)

    val almostSortedList = mutableListOf(2, 0, 1, 5, 63, 4, 6, 44, 87, 99, 283)

    println("Random list:")
    println(insertionSort(list))

    println("Almost sorted list:")
    println(insertionSort(almostSortedList))
}

fun insertionSort(list: MutableList<Int>): MutableList<Int> {

    if (list.size < 2) {
        return list
    }

    var operation = 0
    var target = 1

    while (target < list.size) {
        var counter = target - 1
        while (counter >= 0) {
            operation++
            if (list[target] > list[counter]) {
                break
            }
            if (list[target] <= list[counter]) {
                if (counter == 0 || list[target] >= list[counter - 1]) {
                    list.add(counter, list[target])
                    list.removeAt(target + 1)
                    break
                }
            }
            counter--
        }

        target++
    }

    println("Number of operations for insertion sort is: $operation")
    return list
}

// This is not the selection and it is trying to do the swap but it makes sure to reduce the operations for the sorted ones.
fun insertionSwitchSort(list: MutableList<Int>): MutableList<Int> {
    if (list.size < 2) {
        return list
    }
    var operation = 0
    var selectedIndex = 1
    while (selectedIndex < list.size) {
        var innerIndex = selectedIndex
        while (innerIndex > 0) {
            operation++
            if (list[innerIndex] > list[innerIndex - 1]) {
                break
            }
            val temp = list[innerIndex]
            list[innerIndex] = list[innerIndex - 1]
            list[innerIndex - 1] = temp
            innerIndex--
        }
        selectedIndex++
    }
    println("Number of operation is: $operation")
    return list
}