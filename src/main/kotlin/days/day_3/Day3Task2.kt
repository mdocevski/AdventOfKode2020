package days.day_3

class Day3Task2 {

    fun solution(): Long {
        val inputs = Day3Inputs.inputs
        return listOf(
            SlopeTraverser(inputs, 1, 1),
            SlopeTraverser(inputs, 3, 1),
            SlopeTraverser(inputs, 5, 1),
            SlopeTraverser(inputs, 7, 1),
            SlopeTraverser(inputs, 1, 2),
        )
            .asSequence()
            .map { it.traverseCountingTrees() }
            .fold(1L) { treesProduct, treesEncountered -> treesProduct * treesEncountered }
    }
}