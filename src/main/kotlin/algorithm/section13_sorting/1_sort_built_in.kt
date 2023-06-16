package algorithm.section13_sorting

fun main() {

    val letters = listOf('a', 'd', 'z', 'e', 'r', 'b')
    val basket = listOf(2, 65, 34, 2, 1, 7, 8)

    println(letters.sorted())
    println(basket.sorted()) // The built in sort func might have different result in some languages
}