package bst

class Node<T: Comparable<T>>(tVal: T) {

    var value: T = tVal
    var left: Node<T>? = null
    var right: Node<T>? = null

    operator fun Node<T>.compareTo(b: Node<T>): Int {
        if (this.value == b.value)
            return 0
        if (this.value < b.value)
            return -1
        return 0
    }

}
