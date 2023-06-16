@file:Suppress("SameParameterValue")

package algorithm.section12_recursion

/**
 * Write two functions that finds the factorial of any number.
 *
 * One should use recursive, the other should just use a for loop
 *
 * Factorial: 5! = 5*4*3*2*1
 */
fun main() {
    val number = 5

    printFactorial(number, findFactorialRecursive(number), "Recursive")
    printFactorial(number, findFactorialIterative(number), "Iterative")
}

private fun printFactorial(number: Int, result: Int, message: String) {
    println("Factorial for $number using $message is: $result")
}

/**
 * Time complexity is O(n)
 *
 * 5! = 5 * 4! = 5 * 4 * 3! = 5 * 4 * 3 * 2! = 5 * 4 * 3 * 2 * 1
 *
 * 1! is 1, so this is going to be the base case here.
 */
private fun findFactorialRecursive(number: Int): Int {
    if (number == 1) {
        return 1
    }
    return number * findFactorialRecursive(number - 1)
}

/**
 * Time complexity is O(n)
 */
private fun findFactorialIterative(number: Int): Int { // Time complexity is O(n)
    var result = 1
    for (i in number downTo 1) {
        result *= i
    }
    return result
}