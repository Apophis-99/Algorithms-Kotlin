package searching

fun linearSearch(arr: IntArray, value: Int): Boolean {
    arr.forEach { if (it == value) return true }
    return false
}
