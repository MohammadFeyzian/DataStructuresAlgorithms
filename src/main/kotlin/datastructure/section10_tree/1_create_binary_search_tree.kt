@file:Suppress(
    "MemberVisibilityCanBePrivate", "unused", "UNUSED_VARIABLE", "UNUSED_VALUE",
    "ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE"
)

package datastructure.section10_tree


// The following items are to have a perfect BinarySearchTree

//
//                          100
//             50                         150
//        30          80           120         170
//     10   40     70    90     110   130   160    180
//

fun getBinarySearchTree(): BinarySearchTree {
    val tree = BinarySearchTree()

    tree.insert(100)

    tree.insert(50)
    tree.insert(150)

    tree.insert(30)
    tree.insert(80)
    tree.insert(120)
    tree.insert(170)

    tree.insert(10)
    tree.insert(40)
    tree.insert(70)
    tree.insert(90)
    tree.insert(110)
    tree.insert(130)
    tree.insert(160)
    tree.insert(180)

    return tree
}

fun main() {

    println()

    val tree: BinarySearchTree = getBinarySearchTree()

    println("Original tree")
    tree.print()

    removeNodeFromTree(tree, 110)
    removeNodeFromTree(tree, 100)
    removeNodeFromTree(tree, 130)
//
//    removeTarget = 100
//    tree.remove(removeTarget)
//
//    println()
//    println("Tree after removing $removeTarget")
//    tree.print()


//    val targetLookup = 15
//    println("Node for $targetLookup is: ${tree.lookup(targetLookup)}")
}

private fun removeNodeFromTree(tree: BinarySearchTree, removeTarget: Int) {
    tree.remove(removeTarget)

    println()
    println("Tree after removing $removeTarget")
    tree.print()
}

/**
 * This is a demonstrate for the BinarySearchTree which is just working with Integer numbers.
 *
 * Rules:
 *
 * Each item has one parent and 2 children
 *
 * If an item is grater than the parent will be on the right, otherwise, will be on the left
 *
 * e.g:
 *
 *                9
 *          4           20
 *       1   6     15     170
 */
class BinarySearchTree {

    var root: BinarySearchNode? = null

    fun insert(value: Int) {
        val newNode = BinarySearchNode(value)
        if (root == null) {
            root = newNode
        } else {
            var currentNode: BinarySearchNode = root!!
            while (true) {
                if (value > currentNode.value) {
                    if (currentNode.right == null) {
                        currentNode.right = newNode
                        break
                    } else {
                        currentNode = currentNode.right!!
                    }
                } else {
                    if (currentNode.left == null) {
                        currentNode.left = newNode
                        break
                    } else {
                        currentNode = currentNode.left!!
                    }
                }
            }
        }
    }

    fun lookup(value: Int): BinarySearchNode? {
        if (isEmpty()) {
            return null
        }
        var currentNode = root
        while (currentNode != null) {
            if (value == currentNode.value) {
                return currentNode
            } else {
                currentNode = if (value > currentNode.value) {
                    currentNode.right
                } else {
                    currentNode.left
                }
            }
        }

        return null
    }

    fun remove(value: Int) {
        if (isEmpty()) {
            throw RuntimeException("Tree is empty")
        }

        var parentOfTarget: BinarySearchNode? = null
        var currentNode: BinarySearchNode? = root
        var targetNode: BinarySearchNode? = null

        var isLeftOfParent = false
        while (currentNode != null) {
            if (currentNode.value == value) {
                targetNode = currentNode
                break
            } else {
                parentOfTarget = currentNode
                currentNode = if (value > currentNode.value) {
                    isLeftOfParent = false
                    currentNode.right
                } else {
                    isLeftOfParent = true
                    currentNode.left
                }
            }
        }

        if (targetNode == null) {
            throw RuntimeException("There is no such an element")
        }

        var targetIsLeaf = false
        var targetHasOneChild = false
        var parentOfReplacement: BinarySearchNode? = null

        // (1) Node to be deleted is the leaf: Simply remove it from the tree.
        // (2) Node to be deleted has only one child: Copy the child to the node and delete the node.
        // (3) Node to be deleted has two children: Find inorder successor of the node.
        //      Copy contents of the inorder successor to the node and delete the inorder successor.
        //      This means to find the minimum value on the right sid of the target
        val replacement: BinarySearchNode? =
            if (targetNode.left == null && targetNode.right == null) { // (1)
                targetIsLeaf = true
                null
            } else if (targetNode.left == null) { // (2)
                targetHasOneChild = true
                targetNode.right
            } else if (targetNode.right == null) { // (2)
                targetHasOneChild = true
                targetNode.left
            } else { // (3) find the inorder successor
                parentOfReplacement = targetNode
                var temp = targetNode.right
                while (temp?.left != null) {
                    parentOfReplacement = temp
                    temp = temp.left
                }
                temp
            }

        if (isLeftOfParent) { // (1) -> replacement = null & (2) -> bypass target with replacement
            parentOfTarget?.left = replacement
        } else {
            parentOfTarget?.right = replacement
        }

        if (targetIsLeaf || targetHasOneChild) { // (1) & (2)
            return
        }

        replacement?.left = targetNode.left

        parentOfReplacement?.left = replacement?.right

        if (parentOfReplacement != targetNode) {
            replacement?.right = targetNode.right
        }

        if (parentOfTarget == null) {
            root = replacement
        }
    }

    /**
     * This function related to the Algorithm -> BFS (Breadth First Search)
     *
     * This function using the queue to traverse between nodes.
     */
    fun breadthFirstSearch(): List<Int> {
        var currentNode = root
        val list = mutableListOf<Int>()
        val queue = mutableListOf<BinarySearchNode>()

        currentNode?.let {
            queue.add(it)
        }

        while (queue.isNotEmpty()) {

            currentNode?.left?.let {
                queue.add(it)
            }
            currentNode?.right?.let {
                queue.add(it)
            }

            currentNode?.let {
                list.add(it.value)
            }
            queue.removeAt(0)
            currentNode = if (queue.isNotEmpty()) {
                queue[0]
            } else {
                null
            }
        }

        return list
    }

    fun breadthFirstSearchRecursive(): List<Int> {
        val queue = mutableListOf<BinarySearchNode>()
        root?.let {
            queue.add(it)
        }
        return traverseBreadthFirstSearch(root, mutableListOf(), queue)
    }

    fun traverseBreadthFirstSearch(
        node: BinarySearchNode?,
        nodeList: MutableList<Int>,
        queue: MutableList<BinarySearchNode>
    ): List<Int> {

        if (queue.isEmpty()) {
            return nodeList
        }

        nodeList.add(queue.first().value)
        queue.removeFirst()

        node?.left?.let {
            queue.add(it)
        }

        node?.right?.let {
            queue.add(it)
        }

        return traverseBreadthFirstSearch(queue.firstOrNull(), nodeList, queue)
    }

    fun depthFirstSearchPreorder(): List<Int>{
        return traverseDepthFirstSearchPreorder(root, mutableListOf())
    }

    private fun traverseDepthFirstSearchPreorder(
        node: BinarySearchNode?,
        nodeList: MutableList<Int>
    ): List<Int> {

        if (node != null) {
            nodeList.add(node.value)
        }

        if (node == null) {
            return nodeList
        }

        if (node.left != null) {
            traverseDepthFirstSearchPreorder(node.left, nodeList)
        }

        if (node.right != null) {
            traverseDepthFirstSearchPreorder(node.right, nodeList)
        }

        return traverseDepthFirstSearchPreorder(null, nodeList)
    }

    fun isEmpty(): Boolean {
        return root == null
    }


//    >>--------------------Visual Helpers-----------------------<<


    // ToDo: optimize and fix it after recursive section
    fun print() {

        println()
        println()
        if (root != null) {

            printTree(getFirstFourRows())

            // The rest should be fixed to handle the n items
//            println()
//            println()

//            println("Print the tree with recursion")
//            println()
//
//            val treeList: ArrayList<ArrayList<BinarySearchNode>> = ArrayList()
//            val firstRow: ArrayList<BinarySearchNode> = ArrayList()
//
//            printTree(
//                traverse(root!!, firstRow, firstRow, treeList)
//            )

//            printTree(
//                traverse(root!!)
//            )

        } else {
            println("Tree is empty")
        }

    }

    // Solution for accessing to all elements to print them out
    //
    //               9
    //         4           20
    //      1   6     15     170
    //
    // --> grab 9
    //      --> grab L 4
    //          --> grab L 1
    //          --> grab R 6
    //      --> grab R 20
    //          --> grab L 15
    //          --> grab R 170
    //
    fun traverse(
        node: BinarySearchNode,
        currentRow: ArrayList<BinarySearchNode>,
        nextRow: ArrayList<BinarySearchNode>,
        treeList: ArrayList<ArrayList<BinarySearchNode>>
    ): ArrayList<ArrayList<BinarySearchNode>> {

        println("----> newRow")
        val newRow = ArrayList<BinarySearchNode>()

//        println("Row is $newRow")

        node.left?.let { leftNode ->
            newRow.add(leftNode)
            traverse(leftNode, newRow, newRow, treeList)
        }

        node.right?.let { rightNode ->
//            println("Row is $newRow")
            nextRow.add(rightNode)
            traverse(rightNode, currentRow, nextRow, treeList)
        }

        if (currentRow.isNotEmpty()) {
            treeList.add(0, currentRow)
        }

        return treeList
    }

    private fun getFirstFourRows(): ArrayList<ArrayList<BinarySearchNode?>> {
        val treeList: ArrayList<ArrayList<BinarySearchNode?>> = ArrayList()

        fun newArray(): ArrayList<BinarySearchNode?> {
            return ArrayList()
        }

        var treeRow = newArray()

        val tempRight = root?.right
        val tempLeft = root?.left

        fun addRow(width: ArrayList<BinarySearchNode?>) {
            if (width.isNotEmpty()) {
                treeList.add(width)
            }
        }

        treeRow.add(root)
        addRow(treeRow)

        treeRow = newArray()
        treeRow.add(tempLeft)
        treeRow.add(tempRight)
        addRow(treeRow)

        treeRow = newArray()
        treeRow.add(tempLeft?.left)
        treeRow.add(tempLeft?.right)
        treeRow.add(tempRight?.left)
        treeRow.add(tempRight?.right)
        addRow(treeRow)

        treeRow = newArray()
        treeRow.add(tempLeft?.left?.left)
        treeRow.add(tempLeft?.left?.right)
        treeRow.add(tempLeft?.right?.left)
        treeRow.add(tempLeft?.right?.right)
        treeRow.add(tempRight?.left?.left)
        treeRow.add(tempRight?.left?.right)
        treeRow.add(tempRight?.right?.left)
        treeRow.add(tempRight?.right?.right)
        addRow(treeRow)

        return treeList
    }

    private fun printTree(treeHeight: ArrayList<ArrayList<BinarySearchNode?>>) {
        val builder = StringBuilder()
        treeHeight.forEachIndexed { treeIndex, width ->
            width.forEachIndexed { rowIndex, node ->
                val padding: Int = when (treeIndex) {
                    0 -> 26
                    1 -> if (rowIndex == 0) 13 else 25
                    2 -> when (rowIndex) {
                        0 -> 8
                        1 -> 10
                        2 -> 11
                        else -> 9
                    }
                    else -> when (rowIndex) {
                        0 -> 5
                        1 -> 4
                        2 -> 5
                        3 -> 3
                        4 -> 5
                        5 -> 3
                        6 -> 3
                        else -> 4
                    }
                }
                builder.append("".padStart(padding))
                builder.append(node?.value ?: "--")
            }
            println(builder)
            builder.clear()
        }
    }

}

data class BinarySearchNode(
    val value: Int,
    var left: BinarySearchNode? = null,
    var right: BinarySearchNode? = null
)