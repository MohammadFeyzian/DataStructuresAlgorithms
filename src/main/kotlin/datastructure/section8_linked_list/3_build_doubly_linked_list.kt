package datastructure.section8_linked_list

/**
 * Doubly linked list is a list of objects which are linked together and we can traverse
 * from one to the next one.
 *
 * The difference between Singly and Doubly linked list is that in Doubly the item is connected
 * to the previous and next item and we can traverse from the tail to head
 *
 * 10 --> 5 --> 16 ...
 */

fun main() {

//    println("Init 10")
    val linkedList = DoublyLinkedList(10)
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
//    println("Head prev: ${linkedList.head?.prev?.value}")
//    println("Head next: ${linkedList.head?.next?.value}")
//
//    println("Tail: ${linkedList.tail?.value}")
//    println("Tail prev: ${linkedList.tail?.prev?.value}")
//    println("Tail next: ${linkedList.tail?.next?.value}")

    linkedList.remove(0)
    linkedList.printLinkedList()

    linkedList.remove(5)
    linkedList.printLinkedList()

    linkedList.append(50) // test if the tail is working fine
    linkedList.printLinkedList()

    println("Item at index 3 is: ${linkedList[3]}")
    println("Item at index 0 is: ${linkedList[0]}")

    println("\\033[91mThis is red text\\033[0m")

//    // Everything after this is in red
//    val red = "\u001b[31m"
//
//// Resets previous color codes
//    val reset = "\u001b[0m"
//
//    println(red + "Hello World!" + reset)
}

private fun <T> printLinkedList(linkedList: DoublyLinkedList<T>) {
    println("Size: ${linkedList.size}, LinkedList: $linkedList")
}

class DoublyLinkedList<T>(value: T) {
    private var head: DoublyNode<T>? = DoublyNode(value)
    private var tail: DoublyNode<T>? = head
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
        val newNode = DoublyNode(value)
        newNode.prev = tail
        tail?.next = newNode
        tail = newNode
        increaseSize()
    }

    fun prepend(value: T) {// O(1)
        val newNode = DoublyNode(value)
        head?.prev = newNode
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

        val newNode = DoublyNode(value)
        val leader = traverseToIndex(index)
        val target = leader?.next
        newNode.prev = leader
        newNode.next = target
        target?.prev = newNode
        leader?.next = newNode
        increaseSize()
    }

    fun remove(index: Int) { // O(n)
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index out of range: $index")
        }

        if (size == 1) {
            throw IndexOutOfBoundsException("LinkedList needs at least one element")
        }

        if (index == 0) {
            head = head?.next
            head?.prev = null
        }

        val leader = traverseFromTail(index) // 1
        val target = leader?.next // 10
        val shiftedItem = target?.next
        leader?.next = shiftedItem
        shiftedItem?.prev = leader
        if (index == size - 1) {
            tail = leader
        }
        decreaseSize()
    }

    private fun traverseToIndex(index: Int): DoublyNode<T>? {
        return if (index <= (size / 2)) {
            traverseFromHead(index)
        } else {
            traverseFromTail(index)
        }
    }

    private fun traverseFromHead(index: Int): DoublyNode<T>? {
        var currentNode: DoublyNode<T>? = head
        repeat(index) { innerIndex ->
            if (innerIndex + 1 == index) {
                return currentNode
            } else {
                currentNode = currentNode?.next
            }
        }
        return null
    }

    private fun traverseFromTail(index: Int): DoublyNode<T>? {
        var currentNode: DoublyNode<T>? = tail
        var counter = size - 1
        while (counter >= index) {
            if (counter == index) {
                return currentNode?.prev
            } else {
                currentNode = currentNode?.prev
            }
            counter--
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
        // Everything after this is in red
        val red = "\u001b[31m"

        // Resets previous color codes
        val reset = "\u001b[0m"
        val builder = StringBuilder()
        var currentNode: DoublyNode<T>? = head
        while (currentNode != null) {
            builder.append("${currentNode.prev?.value}")
            builder.append(red + " ${currentNode.value} " + reset)
            builder.append("${currentNode.next?.value}")
            currentNode = currentNode.next
            if (currentNode != null) {
                builder.append(" --> ")
            }
        }
        return builder.toString()
    }
}

data class DoublyNode<T>(
    val value: T,
    var prev: DoublyNode<T>? = null,
    var next: DoublyNode<T>? = null
)