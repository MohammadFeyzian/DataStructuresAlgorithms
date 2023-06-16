package algorithm.section15_dynamic_programming

/**
 * We can compute the fibonacci with the recursion, however, recursion is taking too long
 * if the number gets bigger and the time complexity will be O(2^n)
 *
 * We can take advantage of Dynamic Programming and memoize and cache
 * to fix this issue and heat the time complexity of O(n).
 */
fun main() {
    val n = 40
    val fibonacci = FibonacciClass()
    println("\n------Start-----")
    println("\nFibonacci of $n is: ${fibonacci.recursiveWithCacheing(n)}")
    println("Operation happened in ${fibonacci.calculation} times")
    println("\n------End-----")
}

// 1, 1, 2, 3, 5, 8, 13, 21, ...
private class FibonacciClass {

    val cache = mutableMapOf<Int, Long>()
    var calculation = 0

    fun recursiveWithCacheing(n: Int): Long {
        calculation++
        if (n < 2) {
            return n.toLong()
        }
        return if (cache[n] != null) {
            cache[n]!!
        } else {
            val fib = recursiveWithCacheing(n - 1) + recursiveWithCacheing(n - 2)
            cache[n] = fib
            fib
        }
    }

    fun recursiveNonEfficient(n: Int): Int {
        calculation++
        if (n < 2) {
            return n
        }
        return recursiveNonEfficient(n - 1) + recursiveNonEfficient(n - 2)
    }
}