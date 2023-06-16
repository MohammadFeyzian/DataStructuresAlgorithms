package other

fun main() {

    val list = mutableListOf<Int>()
    for (i in 1..10_000_000) {
        list.add(i)
    }
    counter = 0

    val startTime = System.currentTimeMillis()

//    findANumberInCollectionIterateAll()
//    findANumberInCollectionEvenOrOdd()
    findANumberInCollectionMid(list, 0, list.size - 1, 4_000_000)

    val endTime = System.currentTimeMillis()

    println("Total time :: ${endTime - startTime} ms")
}

fun findANumberInCollectionIterateAll() {
    val n = 10_000_000
    val x = 9_999_996
    var count = 0
    for (i in 0..n step 1) {
        count++
        if (i == x) {
            println("We found the values at $count try")
            break
        }
    }
}

fun findANumberInCollectionEvenOrOdd() {
    val n = 10_000_000
    val x = 9_999_996
    var count = 0
    val isEven = x % 2 == 0
    if (isEven) {
        for (i in 0..n step 2) {
            count++
            if (i == x) {
                println("We found the values at $count try")
                break
            }
        }
    } else {
        for (i in 1..n step 2) {
            count++
            if (i == x) {
                println("We found the values at $count try")
                break
            }
        }
    }
}

var counter = 0

fun findANumberInCollectionMid(list: List<Int>, start: Int, end: Int, x: Int) {
    counter++
    val mid = start + (end - start) / 2

    if (list[mid] == x) {
        println("We found the values at $counter try")
        return
    }
    if (list[mid] > x) {
        findANumberInCollectionMid(list, start, mid - 1, x)
    } else {
        findANumberInCollectionMid(list, mid + 1, end, x)
    }
}