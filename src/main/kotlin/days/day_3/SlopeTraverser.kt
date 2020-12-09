package days.day_3

class SlopeTraverser(
    private val inputs: List<List<Input>>,
    private val horizontalSlope: Int,
    private val verticalSlope: Int
) {

    fun traverseCountingTrees(): Int {
        var row = 0
        var column = 0
        var treeCount = 0
        while (row in inputs.indices && column in inputs.first().indices) {
            if (inputs[row][column] == Input.Tree) {
                treeCount += 1
            }
            row += verticalSlope
            column = (column + horizontalSlope) % inputs.first().size
        }
        return treeCount
    }
}