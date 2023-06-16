package algorithm.section14_searching

/**
 * Linear search is going through the list and compare the items one by one
 * to find the query.
 *
 * The best scenario is to find the element at the first index,
 * and the worst scenario is to find the element at the last index.
 *
 * [6, 12, 1, 34, 4, 9]
 * O(1) .......... O(n)
 */
fun main() {
    val list = mutableListOf(6, 12, 1, 34, 4, 9, 45)
    val query = 34
    println("Index of $query is: ${linearSearch(query, list)}")
}

fun linearSearch(query: Int, list: MutableList<Int>): Int {
    var operations = 0
    var indexOfElement = -1
    for ((index, item) in list.withIndex()) {
        operations++
        if (item == query) {
            indexOfElement = index
            break
        }
    }
    println("Linear search has been done in $operations operations")
    return indexOfElement
}