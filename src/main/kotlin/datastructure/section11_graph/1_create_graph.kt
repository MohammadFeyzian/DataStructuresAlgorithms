package datastructure.section11_graph

/**
 * Create an undirected graph that contains the following items:
 *
 *      3-----4-----5
 *      |     |    |
 *      |     |    |
 *      1-----2    6
 *      \    /
 *       \ /
 *        0
 *
 */
fun main() {
    val graph = AdjacentListGraph()

    graph.addVertex("0")
    graph.addVertex("1")
    graph.addVertex("2")
    graph.addVertex("3")
    graph.addVertex("4")
    graph.addVertex("5")
    graph.addVertex("6")

    graph.addEdge("0", "1")
    graph.addEdge("0", "2")
    graph.addEdge("1", "2")
    graph.addEdge("1", "3")
    graph.addEdge("2", "4")
    graph.addEdge("3", "4")
    graph.addEdge("4", "5")
    graph.addEdge("5", "6")

    graph.showConnections()
}

class AdjacentListGraph {

    private val adjacentList = hashMapOf<String, ArrayList<String>>()
    private var numberOfNodes = 0

    fun addVertex(node: String) {
        adjacentList[node] = arrayListOf()
        numberOfNodes++
    }

    fun addEdge(node1: String, node2: String) {
        // Since it is undirected, we should connect both nodes together
        adjacentList[node1]?.add(node2)
        adjacentList[node2]?.add(node1)
    }

    fun showConnections() {
        println("Connections are:")
        adjacentList.forEach { node ->
            println()
            print("${node.key}-->")
            node.value.forEach { connectedNode ->
                print("$connectedNode ")
            }
        }
    }
}