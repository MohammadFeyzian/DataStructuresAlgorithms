@file:Suppress("unused")

package datastructure.section3_bigO

/**
 * What is the Big O of the [anotherFuncChallenge]?
 *
 * To calculate it we calculate the number of Big Os
 *
 * We have Big O(input1) and Big O(input2)
 *
 * Since we have more than one parameter and the length of each parameter might be different
 * We couldn't say just O(n)
 *
 * We can demonstrate them as O(a + b) or O(n + m)
 */

private fun funcWithMoreThanOneParameters(input1: List<Any>, input2: List<Any>) {
    input1.forEach {// O(a)
        println(it)
    }

    input2.forEach {// O(b)
        println(it)
    }
}