package datastructure.section8_linked_list

/**
 * Check the docs for the reverse in [SinglyLinkedList]
 *
 * Reverse 1 --> 2 --> 3 --> 4 --> 5
 *
 * Result 5 --> 4 --> 3 --> 2 --> 1
 */

fun main() {

    val linkedList = SinglyLinkedList(1)
    linkedList.append(2)
    linkedList.append(3)
    linkedList.append(4)
    linkedList.append(5)

    println()
    println("Original linked list")
    linkedList.printLinkedList()
    println()

    linkedList.reverse()
    println("Reversed linked list")
    linkedList.printLinkedList()
}