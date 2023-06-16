@file:Suppress("UnnecessaryVariable")

package datastructure.section8_linked_list

/**
 * Pointer or reference means that, when we create an object, the value will be created in RAM and that object
 * point (or reference) to that object.
 * If we assign the existing object to another filed, the new filed will point to the same object as the original one.
 */

fun main() {

    val list1 = hashMapOf(Pair("a", true))
    val list2 = list1

    println("Before modification")
    println(list1)
    println(list2)

    list1["a"] = false

    println("After modification")
    println(list1)
    println(list2)
}