@file:Suppress("SpellCheckingInspection", "SameParameterValue")

package datastructure.section6_arrays

// Create a function that reverse a string
// "Hi My name is Mohammad" should be:
// "dammahoM si eman yM iH"

fun main() {

    val originalString = "Hi My name is Mohammad"

    println("Original string is:")
    println(originalString)
    println("Reversed string is:")
    println(reverseString1(originalString))
    println(reverseString2(originalString))

    // Use the built in revers functionality
    println(originalString.reversed())
}

// Adding the element to the beginning of the list with the dynamic list
private fun reverseString1(original: String): String {
    val list = original.toList()
    val reversed = mutableListOf<Char>()
    list.forEach { char ->
        reversed.add(0, char)
    }
    return reversed.joinToString(separator = "")
}

// Creating a static list and adding the element to the specific position
private fun reverseString2(original: String): String {
    val reversed = Array(original.length) { 'a' }
    val count = original.length - 1
    original.forEachIndexed { index, c ->
        reversed[count - index] = c
    }
    return reversed.joinToString(separator = "")
}