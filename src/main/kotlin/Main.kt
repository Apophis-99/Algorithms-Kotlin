import sorting.insertionSort
import kotlin.random.Random

fun main() {

    var nums = (1..100).map { Random.nextInt(0, 100) }.toTypedArray()

    printArray(nums)
    nums = insertionSort(nums)
    printArray(nums)

}

fun <T> printArray(arr: Array<T>) {
    print("[ ")
    arr.forEachIndexed { i, it -> print(it); if (i != arr.size - 1) print(", ") }
    println(" ]")
}
