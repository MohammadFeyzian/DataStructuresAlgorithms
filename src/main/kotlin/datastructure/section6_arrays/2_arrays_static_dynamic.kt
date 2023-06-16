package datastructure.section6_arrays

// When we specify the size of the array, it's an static array
// When we don't specify the size, like using array list, it's a dynamic array

fun main() {

    // Array is a static array which we could not add more items to the list
    val staticArray = Array(4) { index ->
        when (index) {
            0 -> "a"
            1 -> "b"
            2 -> "c"
            else -> "d"
        }
    }

    // Easy way to create Array in Kotlin
    val staticArray1 = arrayOf("e", "f", "g", "h")

    printStaticArray(staticArray, "Static array is:")
    printStaticArray(staticArray1, "Second static array is:")

    // ArrayList is a dynamic list which we can add more items to it
    // Adding the items to the end of the dynamic list is normally O(1),
    // But sometimes if there isn't enough space in the memory location for the list,
    // the list will be copied to a new location with more space for the new items,
    // so the complexity will be O(n) in that case
    val dynamicList = mutableListOf("a", "b", "c")
    dynamicList.add("d")
    dynamicList.add("e")
    // Adding item to the beginning of a list is O(n) as it should iterate through the list and reassign the index.
    dynamicList.add(0, "f")
}

private fun printStaticArray(array: Array<String>, message: String) {
    println(message)
    array.forEach { print("$it, ") }
    println()
    println("----------")
}