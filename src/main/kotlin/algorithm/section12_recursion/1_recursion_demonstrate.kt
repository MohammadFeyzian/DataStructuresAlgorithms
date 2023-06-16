package algorithm.section12_recursion

/**
 * This is a recursive function call which lead to stack over flow error and crashes the app
 */
fun main() {
    inception()
}

private fun inception() {
    inception()
}