package datastructure.section9_stacks_queues

/**
 * The [QueueLinkedList] class represents a LIFO (last-in-first-out) queue of objects.
 *
 * This class use the LinkedList data structure to implement the stack.
 */
fun main() {
    val queue = QueueLinkedList<Int>()
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(5)
    queue.enqueue(7)
    queue.enqueue(9)

    queue.printQueue()

    println("Dequeue ${queue.dequeue()}")
    println("Dequeue ${queue.dequeue()}")

    queue.printQueue()

    println("First item is: ${queue.peek()}")

    println("Dequeue ${queue.dequeue()}")
    println("Dequeue ${queue.dequeue()}")
    println("Dequeue ${queue.dequeue()}")

    queue.printQueue()
}

class QueueLinkedList<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var size = 0

    fun peek(): T? {
        return first?.value
    }

    fun enqueue(value: T) {
        val newNode = Node(value)
        if (size == 0) {
            first = newNode
        } else {
            last?.next = newNode
        }

        last = newNode
        size++
    }

    fun dequeue(): T? {
        val node = first
        first = first?.next
        size--
        if (size == 0) {
            last = null
        }
        return node?.value
    }

    fun printQueue() {
        println("Queue is: $this")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        var node = first

        while (node != null) {
            builder.append(node.value)
            builder.append(" - ")
            node = node.next
        }
        return if (builder.isEmpty()) {
            "Empty"
        } else {
            builder.toString()
        }
    }
}