package sorting

fun <T: Comparable<T>> quickSort(list: Array<T>): Array<T> {

    fun <T: Comparable<T>> partition(list: Array<T>, pivot: T): Pair<Array<T>, Array<T>> {
        var lt: Array<T> = list.copyOfRange(0, 0)
        var gt: Array<T> = list.copyOfRange(0, 0)

        for (i in list.indices) {
            if (list[i] < pivot)
                lt = lt.plus(list[i])
            if (list[i] > pivot)
                gt = gt.plus(list[i])
        }

        return Pair(lt, gt)
    }

    fun sortSmallArray(arr: Array<T>): Array<T> {
        if (arr.size == 2) {
            if (arr[0] > arr[1]) {
                val temp = arr[0]
                arr[0] = arr[1]
                arr[1] = temp
                return arr
            }
        }
        if (arr.size == 3) {
            if (arr[0] > arr[1]) {
                val temp = arr[0]
                arr[0] = arr[1]
                arr[1] = temp
            }
            if (arr[2] < arr[0]) {
                val temp = arr[2]
                arr[2] = arr[1]
                arr[1] = arr[0]
                arr[0] = temp
            }
            else if (arr[2] < arr[1]) {
                val temp = arr[2]
                arr[2] = arr[1]
                arr[1] = temp
            }
            return arr
        }
        return arr;
    }

    var (arr1, arr2) = partition(list, list.last())
    if (arr1.size > 1) {
        arr1 = if (arr1.size <= 3)
            sortSmallArray(arr1)
        else
            quickSort(arr1)
    }
    if (arr2.size > 1) {
        arr2 = if (arr2.size <= 3)
            sortSmallArray(arr2)
        else
            quickSort(arr2)
    }

    return arr1.plus(list.last()).plus(arr2)
}
