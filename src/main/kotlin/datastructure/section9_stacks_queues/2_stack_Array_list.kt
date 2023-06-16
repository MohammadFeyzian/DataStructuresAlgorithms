package datastructure.section9_stacks_queues

/**
 * The [StackArrayList] class represents a last-in-first-out (LIFO) stack of objects.
 *
 * This class use the [ArrayList] data structure to implement the stack.
 */
fun main() {
    val stack = StackArrayList<Int>()
    stack.push(2)
    stack.push(3)
    stack.push(5)
    stack.push(7)
    stack.push(9)

    stack.printStack()

    println("Pop ${stack.pop()}")
    println("Pop ${stack.pop()}")

    stack.printStack()

    println("Top item is: ${stack.pick()}")

    println("Pop ${stack.pop()}")
    println("Pop ${stack.pop()}")
    println("Pop ${stack.pop()}")

    stack.printStack()
}

class StackArrayList<T> {

    private val list = arrayListOf<T>()

    fun pick(): T? {
        return list.lastOrNull()
    }

    fun push(value: T) {
        list.add(value)
    }

    fun pop(): T? {
        val item = list.lastOrNull()
        list.removeLastOrNull()
        return item
    }

    fun printStack() {
        println("Stack is: $this")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        list.forEach {
            builder.append(it)
            builder.append(" - ")
        }
        return if (builder.isEmpty()) {
            "Empty"
        } else {
            builder.toString()
        }
    }
}