@file:Suppress("UNCHECKED_CAST")

package datastructure.section6_arrays

fun main() {

    val list = MyList<String>()

    printTheList(list, "Check Empty list")

    // Get first item in empty list will throw exception
//    println(list.get(0))

    list.push("A0")
    printTheList(list, "Add item to the list")

    repeat(7) {
        list.push("A${it + 1}")
    }
    printTheList(list, "Add more items to the list")

    // Print the third Item
    println("Print item at index 2:")
    println(list.get(2))
    println("----------")

    list.remove(5)
    printTheList(list, "Remove item at index 5")

    list.pop()
    printTheList(list, "Pop last item in the list")
}

private fun printTheList(list: MyList<String>, message: String) {
    println("$message - size is: ${list.size}")
    println("List is:")
    println(list)
    println("----------")
}


class MyList<T : Any> {

    private var length = 0

    val size: Int get() = length

    private var data: Array<Any?> = Array(0) { null }

    fun get(index: Int): T {
        if (index >= length) {
            throw IndexOutOfBoundsException("Index is grater than the list size")
        }
        return data[index] as T
    }

    fun push(item: T) {
        checkCapacity()
        data[length] = item
        length++
    }

    fun pop() {
        data[length - 1] = null
        length--
    }

    fun remove(index: Int) {
        for (loopIndex in index until length) {
            if (loopIndex == length - 1) {
                data[loopIndex] = null
            } else{
                data[loopIndex] = data[loopIndex + 1]
            }
        }
        length--
    }

    private fun checkCapacity() {
        if (length == data.size) {
            val tempData = data
            data = Array(tempData.size + 5) { null } // Add 5 more capacity if needed
            tempData.forEachIndexed { index, item ->
                data[index] = item
            }
        }
    }

    override fun toString(): String {
        val string = StringBuilder()
        string.append("[")

        for ((index, item) in data.withIndex()) {
            if (index >= length) break
            string.append(item)
            if (index < (length - 1)) {
                string.append(", ")
            }
        }
        string.append("]")
        return string.toString()
    }
}