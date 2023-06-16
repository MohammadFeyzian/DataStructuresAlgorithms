@file:Suppress("unused", "VARIABLE_WITH_REDUNDANT_INITIALIZER", "UNUSED_VARIABLE")

package datastructure.section3_bigO

/**
 * What is the Big O of the [funChallenge]?
 *
 * To calculate it we calculate the number of Big Os
 *
 * We have 3 O(1) and 3 O(n)
 *
 * So it's going to be
 *
 * 3 + 3n -> Big O(3 + 3n)
 *
 * So the Big O is O(3 + 3n) which we remove the constants and it's O(n)
 */
private fun funChallenge(input: List<Any>): Int {
    var a = 10 // O(1)
    a = 50 + 3 // O(1)

    for (item in input) { // repeat n times
        anotherFunction() // O(n)
        val strange = true // O(n)
        a++ // O(n)
    }
    return a // O(1)
}

private fun anotherFunction() {

}