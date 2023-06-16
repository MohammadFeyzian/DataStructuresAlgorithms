package datastructure.section9_stacks_queues

fun main() {
    val queue = QueueUsingStack<Int>()
    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(4)
    queue.push(5)

    queue.printQueue()
}

// ToDo: to be implemented
class QueueUsingStack<T> {
    private val stack = StackLinkedList<T>()

    fun push(value: T) {
        stack.push(value)
    }

    fun pop(): T? {
        return stack.pop()
    }

    fun peek(): T? {
        return stack.peek()
    }

    fun printQueue() {
        stack.printStack()
    }
}