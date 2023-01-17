package prims

class Edge<T: Comparable<T>>(tWeight: T) {

    var src: Int = 0
    var dest: Int = 0
    var weight: T = tWeight

    operator fun compareTo(edge: Edge<T>): Int {
        if (this.weight == edge.weight)
            return 0
        if (this.weight < edge.weight)
            return -1
        return 1
    }
}
