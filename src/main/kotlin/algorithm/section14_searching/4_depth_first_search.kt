package algorithm.section14_searching

import datastructure.section10_tree.BinarySearchTree
import datastructure.section10_tree.getBinarySearchTree

/**
 * We are using the [BinarySearchTree] under the data structure section.
 *
 * Depth First Search is used to search a node or traverse between all nodes.
 *
 * In some cases we need to visit all nodes and we use BFS or DFS for that mater.
 *
 * DFS starts from the top and go through the left nodes until it reach the leaf
 * for that line and it step back to visit the childes for the parent if there is any
 *
 * We can use the DFS to see if there is a path between 2 nodes or not.
 *
 * There are 3 types of Depth First Search: inorder, preorder, postorder
 *
 * For example, in the bellow tree:
 *
 *            101
 *      33           105
 *
 * inorder:     33, 101, 105
 * preorder:    101, 33, 105
 * postorder:   33, 105, 101
 */
fun main() {

//
//                          100
//             50                         150
//        30          80           120         170
//     10   40     70    90     110   130   160    180
//
    val tree: BinarySearchTree = getBinarySearchTree()

    println()
    println("Tree is:")
    tree.print()

    println()
    println()
    println("Depth First Search list is")
    println()
    println("Preorder")
    println(tree.depthFirstSearchPreorder())
    println()
}