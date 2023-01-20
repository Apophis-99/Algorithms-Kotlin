package sorting

fun <T: Comparable<T>> bubbleSort(list: Array<T>): Array<T> {
    val arr: Array<T> = list

    var swapsCount = 1
    while (swapsCount > 0) {
        swapsCount = 0
        for (i in 1 until arr.size) {
            if (arr[i - 1] > arr[i]) {
                val temp = arr[i - 1]
                arr[i - 1] = arr[i]
                arr[i] = temp
                swapsCount++
            }
        }
    }
    return arr
}
