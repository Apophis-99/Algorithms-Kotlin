package sorting

fun <T: Comparable<T>> insertionSort(list: Array<T>): Array<T> {

    var i = 1
    while (i < list.size) {
        var j = i
        while (j > 0 && list[j - 1] > list[j]) {
            val temp = list[j]
            list[j] = list[j - 1]
            list[j - 1] = temp
            j--
        }
        i++
    }

    return list
}
