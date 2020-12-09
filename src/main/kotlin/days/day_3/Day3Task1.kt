package days.day_3

class Day3Task1 {

    fun solution(): Int {
        val inputs = Day3Inputs.inputs
        return SlopeTraverser(inputs, 3, 1).traverseCountingTrees()
    }
}