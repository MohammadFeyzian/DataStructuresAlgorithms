package datastructure.section7_hash_tables

fun main() {

    val user = hashMapOf(
        Pair("age", 54),
        Pair("name", "Kylie"),
        Pair("magic", true),
        Pair("scream") { println("ahh!") }
    )

    println(user["age"]) // O(1)
    user["spell"] = "abra ka da bra" // O(1)

    println(user)
}