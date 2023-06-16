@file:Suppress("unused", "UNUSED_VARIABLE")

package datastructure.section3_bigO

/**
 * What is the Big O of the [anotherFuncChallenge]?
 *
 * To calculate it we calculate the number of Big Os
 *
 * We have 4 O(1) and 3 O(n) and 2 O(n)
 *
 * So it's going to be
 *
 * 4 + 3n + 2n -> Big O(4 + 5n)
 *
 * So the Big O is O(4 + 5n) which we remove the constants and it's O(n)
 */

private fun anotherFuncChallenge(input: List<Int>) {
    val a = 5 // O(1)
    val b = 10 // O(1)
    val c = 50 // O(1)
    for (item in input){ // repeat n times
        val x = item + 1 // O(n)
        val y = item + 2 // O(n)
        val z = item + 3 // O(n)
    }
    for (item in input){ // repeat n times
        val p = item * 2 // O(n)
        val q = item * 2 // O(n)
    }
    val whoAmI = "I don't know" // O(1)
}