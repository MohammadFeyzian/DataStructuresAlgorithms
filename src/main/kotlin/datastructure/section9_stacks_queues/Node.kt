package datastructure.section9_stacks_queues

data class Node<T>(
    val value: T,
    var next: Node<T>? = null
)