@file:Suppress("unused")

package datastructure.section8_linked_list

/**
 * Singly linked list is a list of objects which are linked together and we can traverse
 * from one to the next one.
 *
 * 10 --> 5 --> 16 ...
 */

fun main() {

    val linkedList = SinglyLinkedList(10)
    linkedList.printLinkedList()

//    println("append 5")
    linkedList.append(5)
    linkedList.printLinkedList()

//    println("append 16")
    linkedList.append(16)
    linkedList.printLinkedList()

//    println("prepend 1")
    linkedList.prepend(1)
    linkedList.printLinkedList()

//    println("insert 60 at index 2")
    linkedList.insert(2, 60)
    linkedList.printLinkedList()

//    println("insert 90 at index 4")
    linkedList.insert(4, 90)
    linkedList.printLinkedList()

//    println("insert 20 at index 6 which is tail")
    linkedList.insert(6, 20) // index is last item index plus 1
    linkedList.printLinkedList()

//    println("insert 30 at index 0 which is head")
    linkedList.insert(0, 30)
    linkedList.printLinkedList()

//    println("remove index 2")
    linkedList.remove(2)
    linkedList.printLinkedList()

//    println("Head and Tail:")
//
//    println("Head: ${linkedList.head?.value}")
//    println("Head before: ${linkedList.head?.before?.value}")
//    println("Head next: ${linkedList.head?.next?.value}")
//
//    println("Tail: ${linkedList.tail?.value}")
//    println("Tail before: ${linkedList.tail?.before?.value}")
//    println("Tail next: ${linkedList.tail?.next?.value}")

    linkedList.remove(0)
    linkedList.printLinkedList()

    linkedList.remove(5)
    linkedList.printLinkedList()

    linkedList.append(50) // test if the tail is working fine
    linkedList.printLinkedList()

    println("Item at index 3 is: ${linkedList[3]}")
    println("Item at index 0 is: ${linkedList[0]}")

}

class SinglyLinkedList<T>(value: T) {
    private var head: SinglyNode<T>? = SinglyNode(value)
    private var tail: SinglyNode<T>? = head
    var size: Int = 1

    operator fun get(index: Int): T? { // O(n)
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index out of range: $index")
        }

        if (index == 0) {
            return head?.value // First item
        }

        if (index == size - 1) {
            return tail?.value // Last item
        }

        val leader = traverseToIndex(index)
        return leader?.next?.value
    }

    fun append(value: T) { // O(1)
        val newNode = SinglyNode(value)
        tail?.next = newNode
        tail = newNode
        increaseSize()
    }

    fun prepend(value: T) {// O(1)
        val newNode = SinglyNode(value)
        newNode.next = head
        head = newNode
        increaseSize()
    }

    fun insert(index: Int, value: T) { // O(n)
        if (index < 0) {
            throw IndexOutOfBoundsException("Index out of range: $index")
        }

        if (index >= size) {
            append(value)
            return
        }

        if (index == 0) {
            prepend(value)
            return
        }

        val newNode = SinglyNode(value)
        val leader = traverseToIndex(index)
        val target = leader?.next

        newNode.next = target
        leader?.next = newNode
        increaseSize()
    }

    fun remove(index: Int): SinglyNode<T>? { // O(n)
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index out of range: $index")
        }

        if (size == 1) {
            throw IndexOutOfBoundsException("LinkedList needs at least one element")
        }

        if (index == 0) {
            head = head?.next
        }

        val leader = traverseToIndex(index)
        val target = leader?.next
        leader?.next = target?.next
        if (index == size - 1) {
            tail = leader
        }
        decreaseSize()
        return target
    }

    /**
     * To understand the reverse, assume that we have a list with these references
     *
     * (Head) 1 --> 2 --> 3 --> 4 --> 5 (Tail) :: Result: [ 1, 2, 3, 4, 5 ]
     *
     * We don't want to grab the element to put it before or after another element.
     *
     * All we want is to change the reference directions:
     *
     * (Tail) 1 <-- 2 <-- 3 <-- 4 <-- 5 (Head) :: Result: [ 5, 4, 3, 2, 1 ]
     */
    fun reverse() { // O(n)

        if (size <= 1) {
            return
        }

        var first = head
        var second = head?.next

        while (second != null) {
            val temp = second.next
            second.next = first
            first = second
            second = temp
        }

        tail = head
        tail?.next = null
        head = first
    }

    private fun traverseToIndex(index: Int): SinglyNode<T>? {
        var currentNode: SinglyNode<T>? = head
        repeat(index) { innerIndex ->
            if (innerIndex + 1 == index) {
                return currentNode
            } else {
                currentNode = currentNode?.next
            }
        }
        return null
    }

    private fun increaseSize() {
        size++
    }

    private fun decreaseSize() {
        size--
    }

    fun printLinkedList() {
        println("Size: $size, LinkedList: ${printInLine()}")
    }

    override fun toString(): String {
        return printInLine()
    }

    private fun printInLine(): String {
        val builder = StringBuilder()
        builder.append("[ ")
        var counter = 0
        var currentNode: SinglyNode<T>? = head
        while (counter < size) {
            if (counter > 0) {
                builder.append(", ")
            }
            builder.append(currentNode?.value)
            currentNode = currentNode?.next
            counter++
        }
        builder.append(" ]")
        return builder.toString()
    }

    private fun printInnerObjects(): String {
        val builder = StringBuilder()
        var currentNode: SinglyNode<T>? = head
        builder.append("{\n")
        var nodeCounter = 1
        fun padding(): String {
            return "".padStart(nodeCounter * 3)
        }
        while (currentNode != null) {
            builder.append("${padding()}value: ${currentNode.value}\n")
            currentNode = currentNode.next
            if (currentNode != null) {
                builder.append("${padding()}next: {\n")
            } else {
                builder.append("${padding()}next: null\n")
            }
            nodeCounter++
        }
        repeat(nodeCounter) {
            nodeCounter--
            builder.append("${padding()}}\n")
        }
        return builder.toString()
    }
}

data class SinglyNode<T>(
    var value: T,
    var next: SinglyNode<T>? = null
)