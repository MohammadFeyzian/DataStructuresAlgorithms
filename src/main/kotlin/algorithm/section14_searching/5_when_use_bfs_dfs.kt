package algorithm.section14_searching

/**
 * 1- If you know a solution is not far from the root of the tree:
 * BFS as this algorithm start from top to bottom.
 *
 * 2- If the tree is very deep and solutions are rare:
 * BFS as the DFS takes longer time and solution likely will be at the top levels
 *
 * 3- If the tree is very wide:
 * DFS as BFS will need to much memory
 *
 * 4- If solutions are frequent but located deep in the tree:
 * DFS
 *
 * 5- Determining whether a path exists between two nodes:
 * DFS
 *
 * 7- Finding the shortest path:
 * BFS
 */