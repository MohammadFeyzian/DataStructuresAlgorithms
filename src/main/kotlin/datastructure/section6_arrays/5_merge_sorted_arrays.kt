@file:Suppress("UNUSED_PARAMETER")

package datastructure.section6_arrays

// Merge 2 sorted arrays and the result should be sorted

fun main() {
    val list1 = listOf(0, 3, 4, 31, 45, 78, 101, 220, 990)
    val list2 = listOf(4, 6, 30, 40, 70, 100, 300, 500)

    println("List 1 is:")
    println(list1)
    println("List 2 is:")
    println(list2)

    println("Merged list is: ")
    println(mergeAndSortSortedArrays1(list1, list2))
    println(mergeAndSortSortedArrays2(list1, list2))
//    println(mergeAndSortSortedArrays3(list1, list2))
}

// This function using the for loop and add the first list and iterate through the second list to find the
// next possible index for the next item in the second list
// The drawback for this function is that the nested loop always happens for the whole list
fun mergeAndSortSortedArrays1(list1: List<Int>, list2: List<Int>): List<Int> {

    // Check the inputs
    if (list1.isEmpty()) {
        return list2
    } else if (list2.isEmpty()) {
        return list1
    }

    var operation = 0
    val mergedList = arrayListOf<Int>()
    mergedList.addAll(list1)
    list2.forEach { item2 ->
        var targetIndex = 0
        innerLoop@ for ((index, item1) in mergedList.withIndex()) {
            operation++
            targetIndex = index
            if (item2 <= item1) {
                break@innerLoop
            }
        }
        mergedList.add(targetIndex, item2)
    }
    println("--> $operation operations")
    return mergedList
}

// This function uses the for loop and adds the first list and iterate through the
// second list to find the next possible position.
// The difference between func 1 and 2 is that the func 2 grabs the needed part of the
// Merged list (list1) instead of going through the whole list
fun mergeAndSortSortedArrays2(list1: List<Int>, list2: List<Int>): List<Int> {

    // Check the inputs
    if (list1.isEmpty()) {
        return list2
    } else if (list2.isEmpty()) {
        return list1
    }

    val mergedList = arrayListOf<Int>()
    mergedList.addAll(list1)
    var operation = 0

    var iterator = 0
    list2.forEach { item2 ->
        var targetIndex = 0

        innerLoop@ for (i in iterator until mergedList.size) {
            operation++
            iterator++
            targetIndex = i
            if (item2 <= mergedList[i]) {
                break@innerLoop
            }
        }
        mergedList.add(targetIndex, item2)
    }
    println("--> $operation operations")
    return mergedList
}

// Can we have it without inner for loop?
fun mergeAndSortSortedArrays3(list1: List<Int>, list2: List<Int>): List<Int> {

    // Check the inputs
    if (list1.isEmpty()) {
        return list2
    } else if (list2.isEmpty()) {
        return list1
    }

    val mergedList = arrayListOf<Int>()

    var element1: Int = list1[0]
    var element2: Int = list2[0]
    var i = 1
    var j = 1

    // Wrong solution
    while (element1 != list1[list1.size - 1] && element2 != list2[list2.size - 1]) {
        if (element1 < element2) {
            mergedList.add(element1)
            element1 = list1[i]
            i++
        } else {
            mergedList.add(element2)
            element2 = list2[j]
            j++
        }
    }

    return mergedList
}