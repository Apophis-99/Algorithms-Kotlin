package prims

class Graph<T : Comparable<T>>(n: Int) {
    private var v: Int = n
    private var edges: MutableList<Edge<T>> = mutableListOf()

    fun vertices(): Int {
        return v
    }
    fun edges(): List<Edge<T>> {
        return edges
    }

    fun addEdge(edge: Edge<T>) {
        if (edge.src in 1..v && edge.dest in 1..v)
            edges.add(edge)
    }

    fun outgoingEdges(): List<Edge<T>> {
        var temp = mutableListOf<Edge<T>>()
        return temp.toList()
    }

    fun print() {

    }

}
