package datastructure.section3_bigO

/**
 * For the space Complexity we don't care about the input
 *
 * We just look how much space the function is created.
 *
 * Space complexity of [firstFunction] is O(1)
 *
 * Space complexity for [secondFunction] is O(n)
 *
 * Space complexity for the [checkStringSize] is O(1) as the length is a property
 * and there's no need to go through the whole string to find out the size
 */

fun main() {
//    firstFunction(arrayOf(1, 2, 3, 4, 5))
//    println(secondFunction(6))
    checkStringSize()
}

private fun firstFunction(n: Array<Int>) {
    n.forEach {
        println("Print $it")
    }
}

private fun secondFunction(n: Int): ArrayList<String> {
    val newList = arrayListOf<String>()

    for (i in 0 until n) {
        newList.add("Value $i")
    }
    return newList
}

private fun checkStringSize() {
    val string = "Hello World"

    println("Length of the string is ${string.length}")
}