package algorithm.section14_searching

/**
 * When we have a sorted list, we can perform the Binary Search
 * to find an element.
 *
 * The key is that, we store the data in a sorted list (or binary tree)
 * instead of a random list to be able to have the Binary Search for it.
 *
 * The concept is exactly what we have in the Binary Search Tree.
 *
 * Binary Search is using divide and conquer approach and throw away half
 * of the list in a time and it it will give us the
 * O(log n) time complexity.
 *
 * [1, 4, 6, 9, 12, 34, 45]
 *
 * The worst scenario to find an item is O(log n)
 */
fun main() {
    val list = mutableListOf(1, 4, 6, 9, 12, 34, 45)
    val query = 45
    println("Index of $query is: ${binarySearch(query, list)}")
}

fun binarySearch(query: Int, list: MutableList<Int>): Int {
    if (list.isEmpty()) {
        return -1
    }
    if (list.size == 1) {
        return if (query == list[0]) {
            0
        } else {
            -1
        }
    }
    var operations = 0
    var indexOfElement = -1

    var startIndex = 0
    var endIndex = list.size - 1

    while (endIndex - startIndex > 0) {
        operations++
        val middleIndex = startIndex + ((endIndex - startIndex) / 2)
        if (query == list[middleIndex]) {
            indexOfElement = middleIndex
            break
        }
        if (endIndex - startIndex == 1) {
            if (query == list[middleIndex + 1]) {
                indexOfElement = middleIndex + 1
                break
            }
            break
        }
        if (query > list[middleIndex]) {
            startIndex = middleIndex
        } else {
            endIndex = middleIndex
        }
    }

    println("Binary search has been done in $operations operations")
    return indexOfElement
}