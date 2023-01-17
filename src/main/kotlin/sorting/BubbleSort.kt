package sorting

import printList

fun bubbleSort(list: IntArray): IntArray {
    val arr: IntArray = list

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
        printList(arr)
    }
    return arr
}
