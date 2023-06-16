@file:Suppress("SameParameterValue", "unused")

package datastructure.section3_bigO

/**
 * The time to perform this function with the presented algorithm might be totally different
 * in variety of devices and systems; It might be faster or slower; If the input gets bigger,
 * the time also gets bigger
 */

fun main() {
//    findNemo(nemo, "nemo")
//    findNemo(nemoList, "nemo10")
    datastructure.section3_bigO.findNemo(
        datastructure.section3_bigO.largeList,
        "nemo999999"
    )
}

private val nemo = listOf("nemo")
private val nemoList = listOf(
    "nemo1", "nemo2", "nemo3", "nemo4", "nemo5",
    "nemo6", "nemo7", "nemo8", "nemo9", "nemo10",
)
private val largeList = arrayListOf<String>().apply {
    repeat(1_000_000) {
        add("nemo$it")
    }
}

private fun findNemo(list: List<String>, target: String) {
    val startTime = System.currentTimeMillis()
    for (name in list) {
        if (name == target) {
            println("Found TARGET!")
        }
    }
    val endTime = System.currentTimeMillis()
    println("Operations took ${endTime - startTime} ms")
}