package matrices

import java.lang.Exception

class Matrix(r: Int, c: Int) {
    private val data: Array<Array<Double>>
    private val rows: Int = r
    private val cols: Int = c

    init {
        data = Array(size = rows, init = { Array(size = cols, init = { 0.0 }) })
    }

    fun initialise(vararg values: Double) {
        for (i in values.indices) {
            data[i % cols][i / rows] = values[i]
        }
    }

    fun setAt(row: Int, col: Int, value: Double): Matrix {
        if (row > rows)
            throw Exception("Row index ($row) is greater than the number of rows ($rows)")
        if (col > cols)
            throw Exception("Column index ($col) is greater than the number of columns ($cols)")
        if (row < 0)
            throw Exception("Row index must be greater than 0")
        if (col < 0)
            throw Exception("Column index must be greater than 0")
        data[row][col] = value
        return this
    }

    fun getInverse(): Matrix {
        if (rows != cols)
            throw Exception("Can't get inverse a matrix that is not square (rows = cols)")

        var inv = Matrix(rows, cols)

        if (rows == 2) {
            val det = getDeterminant()
            inv.setAt(0, 0, data[1][1])
            inv.setAt(1, 1, data[0][0])
            inv.setAt(0, 1, -data[0][1])
            inv.setAt(1, 0, -data[1][0])
            inv *= 1 / det
        }

        return inv
    }

    fun getDeterminant(): Double {
        if (rows != cols)
            throw Exception("Can't get determinant of a matrix that is not square (rows = cols)")

        if (rows == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0]
        }
        if (rows == 3) {
            var sum = 0.0
            sum += data[0][0] * (data[1][1] * data[2][2] - data[1][2] * data[2][1])
            sum += data[0][1] * (data[1][0] * data[2][2] - data[1][2] * data[2][0])
            sum += data[0][2] * (data[1][0] * data[2][1] - data[1][1] * data[2][0])
            return sum
        }

        return 0.0
    }

    override fun toString(): String {
        var longestData = 0
        data.forEach { row -> row.forEach { if (it.toString().length > longestData) longestData = it.toString().length } }
        longestData++

        val str = "⎧ ${data[0][0].toString().padStart(longestData, ' ')} ${data[0][1].toString().padStart(longestData, ' ')} ⎫\n" +
                  "⎩ ${data[1][0].toString().padStart(longestData, ' ')} ${data[1][1].toString().padStart(longestData, ' ')} ⎭\n"
        return str
    }

    operator fun times(multiplier: Double): Matrix {
        for (i in 0 until rows)
            for (j in 0 until cols)
                setAt(i, j, multiplier * data[i][j])
        return this
    }
}
