package datastructure.section6_arrays

val strings = mutableListOf("a", "b", "c", "d")

fun main() {

    printList("Entry list is:")

    // Lookup: O(1) as we access to the exact element on the memory
    println("Element at index 2 is:")
    println(strings[2])
    println("----------")

    // Push: O(1) as we add an element at the end without any loop
    strings.add("e")
    printList("List after adding element at the end:")

    // Pop: O(1) without looping in the list
    strings.removeLast()
    strings.removeLast()
    printList("List after popping 2 items")

    // Insert: O(n) as we need to loop in the list and reassign the indexes to each element
    strings.add(0, "x")
    printList("List after adding x at the beginning:")

    // Remove: O(n) as we need to loop in the list and reassign the indexes to each element
    strings.removeAt(2)
    printList("List after removing an item at index 2")
}

private fun printList(message: String){
    println(message)
    println(strings)
    println("----------")
}