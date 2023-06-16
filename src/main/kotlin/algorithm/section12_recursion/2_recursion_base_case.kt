package algorithm.section12_recursion

/**
 * We can set 3 rules for the recursions:
 *
 * 1. Identify the base case: counter > 3 return `Done` in this case
 *
 * 2. Identify the recursive case: counter < 3 in this case
 *
 * 4. Get closer and closer and return when needed. Usually you have 2 returns
 */
fun main() {
    counter = 0
    println(inception())
}

private var counter = 0

private fun inception(): String {
    if (counter > 3) {
        return "Done"
    }
    counter++
    return inception() // We have to return the function to be able to return the `Done` which is the final returned value
}