package sorting

fun <T: Comparable<T>> mergeSort(list: Array<T>): Array<T> {

    if (list.size == 1)
        return list

    if (list.size == 2) {
        if (list[0] > list[1]) {
            val temp = list[0]
            list[0] = list[1]
            list[1] = temp
        }
        return list
    }

    val midPoint = list.size / 2

    //var part1: Array<T> = list.toList().subList(0, midPoint)
    var part1 = list.copyOfRange(0, midPoint)
    //var part2: Array<T> = list.toList().subList(midPoint, list.size).toTypedArray()
    var part2: Array<T> = list.copyOfRange(midPoint, list.size)

    part1 = mergeSort(part1)
    part2 = mergeSort(part2)

    var merged: Array<T> = list.copyOfRange(0, 0)

    var iter1 = 0
    var iter2 = 0

    //
    // Merges two ordered lists together and keeps them ordered
    //

    while (iter1 != part1.size && iter2 != part2.size) {
        if (part1[iter1] < part2[iter2]) {
            merged = merged.plus(part1[iter1])
            iter1++
        }
        else {
            merged = merged.plus(part2[iter2])
            iter2++
        }
    }

    if (iter1 != part1.size)
        for (i in iter1 until part1.size)
            merged = merged.plus(part1[i])
    if (iter2 != part2.size)
        for (i in iter2 until part2.size)
            merged = merged.plus(part2[i])

    return merged
}
