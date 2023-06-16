package common

fun startPrint() {
    println()
    println("Start computing...")
    println()
}

fun endPrint(operations: Long, startTime: Long? = null, endTime: Long? = null) {
    println("$operations operations happened")
    println()
    endTime?.let {
        startTime?.let {
            println("Operation took ${endTime - startTime} ms")
            println()
        }
    }
}