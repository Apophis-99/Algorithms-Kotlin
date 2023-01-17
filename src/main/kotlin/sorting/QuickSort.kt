package sorting
fun quickSort(list: IntArray): IntArray {

    fun partition(list: IntArray, pivot: Int): Pair<IntArray, IntArray> {
        val lt: MutableList<Int> = IntArray(0).toMutableList()
        val gt: MutableList<Int> = IntArray(0).toMutableList()

        for (i in list.indices) {
            if (list[i] < pivot)
                lt.add(list[i])
            if (list[i] > pivot)
                gt.add(list[i])
        }

        return Pair(lt.toIntArray(), gt.toIntArray())
    }

    fun sortSmallArray(arr: IntArray): IntArray {
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
