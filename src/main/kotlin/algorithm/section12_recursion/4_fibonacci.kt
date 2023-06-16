@file:Suppress("SameParameterValue")

package algorithm.section12_recursion

/**
 * Given a number N return the index value of the Fibonacci sequence,
 * where the sequence is:
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ..
 *
 * The pattern of the sequence is that each value is the sum of the 2 previous values,
 * that means that for N=6 -> 5+3 = 8
 *
 * Big O:
 *
 * If we use the recursive function, Big O for this function will be Exponential
 * than means O(2^n)
 *
 * O(2^N) Exponential - Recursive algorithms that solve a problem of size N
 */
fun main() {
    val n = 6

    printFibonacci(n, fibonacciRecursive(n), "Recursive")
    printFibonacci(n, fibonacciIterative1(n), "Iterative1")
    printFibonacci(n, fibonacciIterative2(n), "Iterative2")

}

private fun printFibonacci(n: Int, result: Int, message: String) {
    println("Fibonacci for index $n using $message is: $result")
}

/**
 * If we use the recursive function, Big O for this function will be Exponential
 * than means O(2^n)
 *
 * O(2^N) Exponential - Recursive algorithms that solve a problem of size N
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ..
 */
private fun fibonacciRecursive(n: Int): Int {
    if (n < 2) {
        return n
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
}

// O(n)
// fibonacciIterative2 is cleaner than this one
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ..
private fun fibonacciIterative1(n: Int): Int {
    if (n < 2) {
        return n
    }

    var firstFibonacci = 0
    var secondFibonacci = 1
    var result = 0
    var counter = 2
    while (counter <= n) {
        result = firstFibonacci + secondFibonacci
        firstFibonacci = secondFibonacci
        secondFibonacci = result
        counter++
    }

    return result
}

// O(n)
// Cleaner way
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ..
private fun fibonacciIterative2(n: Int): Int {
    val list = arrayListOf(0, 1)

    for (i in 2..n) {
        list.add(list[i - 1] + list[i - 2])
    }

    return list[n]
}