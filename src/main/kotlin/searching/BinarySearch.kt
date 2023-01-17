package searching

fun binarySearch(arr: IntArray, value: Int): Boolean {
    val midpoint = arr.size / 2
    if (arr.size == 1 && arr[0] != value)
        return false
    if (arr[midpoint] == value)
        return true
    if (value < arr[midpoint])
        return binarySearch(arr.toList().subList(0, midpoint).toIntArray(), value)
    if (value > arr[midpoint])
        return binarySearch(arr.toList().subList(midpoint, arr.size).toIntArray(), value)
    return false
}
