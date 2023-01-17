import bst.IntBST
import prims.Graph
import searching.binarySearch
import kotlin.random.Random

fun main() {
    val bst = IntBST(50, 10, 13, 14, 3, 9, 27, 2)
}

fun printList(arr: IntArray) {
    print("[ ")
    arr.forEachIndexed { i, it -> print(it); if (i != arr.size - 1) print(", ") }
    println(" ]")
}
