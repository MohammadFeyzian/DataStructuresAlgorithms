package datastructure.section7_hash_tables

/**
 * Google Question
 * Given an array and find the first recurring item
 *
 * Array = [2,5,1,2,3,5,1,2,4] should return 2
 *
 * Array = [2,1,1,2,3,4,1,2,4] should return 1
 *
 * Array = [2,3,4,5] should return null
 */
fun main() {

    val list1 = listOf(2, 5, 1, 2, 3, 5, 1, 2, 4)
    val list2 = listOf(2, 1, 1, 2, 3, 4, 1, 2, 4)
    val list3 = listOf(2, 3, 4, 5)

    println("Recurring item in list 1 with hash map is: ${findTheFirstRecurringItemHashTable(list1)}")
    println("Recurring item in list 2 with hash map is: ${findTheFirstRecurringItemHashTable(list2)}")
    println("Recurring item in list 3 with hash map is: ${findTheFirstRecurringItemHashTable(list3)}")

    println()
    println("Recurring item in list 1 with loop is: ${findTheFirstRecurringItemLoop(list1)}")
    println("Recurring item in list 2 with loop is: ${findTheFirstRecurringItemLoop(list2)}") // Wrong answer
    println("Recurring item in list 3 with loop is: ${findTheFirstRecurringItemLoop(list3)}")
}

// Optimized solution with hash tables
private fun findTheFirstRecurringItemHashTable(list: List<Int>): Int? { // O(n)
    val hashTable = hashMapOf<Int, Boolean>()
    for (item in list) {
        if (hashTable[item] == true) {
            return item
        } else {
            hashTable[item] = true
        }
    }

    return null
}

// Find recurring item, this is not working correctly for the list2 as it checks the first item with all the list
// ToDo: Fix this
private fun findTheFirstRecurringItemLoop(list: List<Int>): Int? { // O(n^2)
    list.forEachIndexed { index, item1 ->
        if (index < list.size - 2) {
            list.subList(index + 1, list.size - 1).forEach { item2 ->
                if (item1 == item2) {
                    return item1
                }
            }
        }
    }
    return null
}