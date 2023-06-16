package datastructure.section9_stacks_queues

/**
 * The [StackLinkedList] class represents a last-in-first-out (LIFO) stack of objects.
 *
 * This class use the LinkedList data structure to implement the stack.
 */
fun main() {
    val stack = StackLinkedList<Int>()
    stack.push(2)
    stack.push(3)
    stack.push(5)
    stack.push(7)
    stack.push(9)

    stack.printStack()

    println("Pop ${stack.pop()}")
    println("Pop ${stack.pop()}")

    stack.printStack()

    println("Top item is: ${stack.peek()}")


    println("Pop ${stack.pop()}")
    println("Pop ${stack.pop()}")
    println("Pop ${stack.pop()}")

    stack.printStack()
}

class StackLinkedList<T> {

    private var top: Node<T>? = null

    private var bottom: Node<T>? = null

    private var size: Int = 0

    fun peek(): T? {
        return top?.value
    }

    fun push(value: T) {
        val newNode = Node(value)
        newNode.next = top
        top = newNode
        if (size == 0) {
            bottom = top
        }
        size++
    }

    fun pop(): T? {
        val item = top
        top = top?.next
        size--
        if (size == 0) {
            bottom = null
        }
        return item?.value
    }

    fun printStack() {
        println("Stack is: $this")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        var node = top
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