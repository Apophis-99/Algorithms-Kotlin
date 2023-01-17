package sorting

fun mergeSort(list: IntArray): IntArray {

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

    var part1 = list.toList().subList(0, midPoint).toIntArray()
    var part2 = list.toList().subList(midPoint, list.size).toIntArray()

    part1 = mergeSort(part1)
    part2 = mergeSort(part2)

    val merged: MutableList<Int> = mutableListOf()

    var iter1 = 0
    var iter2 = 0

    //
    // Merges two ordered lists together and keeps them ordered
    //

    while (iter1 != part1.size && iter2 != part2.size) {
        if (part1[iter1] < part2[iter2]) {
            merged.add(part1[iter1])
            iter1++
        }
        else {
            merged.add(part2[iter2])
            iter2++
        }
    }

    if (iter1 != part1.size)
        for (i in iter1 until part1.size)
            merged.add(part1[i])
    if (iter2 != part2.size)
        for (i in iter2 until part2.size)
            merged.add(part2[i])

    return merged.toIntArray()
}
