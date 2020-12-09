package days.day_3

class Day3Task1 {

    fun solution(): Int {
        val inputs = Day3Inputs.inputs
        var row = 0
        var column = 0
        var treeCount = 0
        while (row in inputs.indices && column in inputs.first().indices) {
            println("Row: $row, column: $column, value: ${inputs[row][column]}")
            if (inputs[row][column] == Input.Tree) {
                treeCount += 1
            }
            row += 1
            column = (column + 3) % inputs.first().size
        }
        return treeCount
    }
}