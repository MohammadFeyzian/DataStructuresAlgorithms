package algorithm.section14_searching

import datastructure.section10_tree.BinarySearchTree
import datastructure.section10_tree.getBinarySearchTree

/**
 * We are using the [BinarySearchTree] under the data structure section.
 *
 * Breadth First Search is used to search a node or traverse between all nodes.
 *
 * In some cases we need to visit all nodes and we use BFS or DFS for that mater.
 *
 * BFS starts from the top level and left to right between the nodes to travers
 * between the nodes and it uses queue to keep track of the references of the
 * children for the nodes that we are visiting to be able to traverse to the
 * next level.
 *
 * We can use teh BFS to find the shortest path.
 *
 * For example, in the bellow tree:
 *
 *                       100
 *          50                         150
 *     30          80           120         170
 *  10   40     70    90     110   130   160    180
 *
 * We get the following list:
 *
 * [100, 50, 150, 30, 80, 120, 170, 10, 40, 70, 90, 110, 130, 160, 180]
 */
fun main() {

    val tree: BinarySearchTree = getBinarySearchTree()

    println()
    println("Tree is:")
    tree.print()

    println()
    println()
    println("Breadth First Search list is")
    println()
    println(tree.breadthFirstSearch())
    println(tree.breadthFirstSearchRecursive())
    println()
}