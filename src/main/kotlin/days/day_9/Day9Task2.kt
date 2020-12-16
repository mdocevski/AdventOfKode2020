package days.day_9

class Day9Task2 {

    class SolutionNotFound : Throwable()

    fun processSubset(previousTaskSolution: Long, inputs: List<Long>, startIndex: Int, endIndex: Int): Long {
        val sequence = inputs.slice(startIndex..endIndex)
        val subsetSum = sequence.sum()
        if (subsetSum == previousTaskSolution) {
            return sequence.minOrNull()!! + sequence.maxOrNull()!!
        } else {
            throw SolutionNotFound()
        }
    }

    fun processingSubsetsWithStartingIndex(previousTaskSolution: Long, inputs: List<Long>, startIndex: Int): Long {
        var endIndex = startIndex + 1
        while (endIndex in inputs.indices) {
            try {
                return processSubset(previousTaskSolution, inputs, startIndex, endIndex)
            } catch (t: SolutionNotFound) {
                endIndex += 1
            }
        }
        throw SolutionNotFound()
    }

    fun solve(forInputs: List<Long> = Day9Inputs.inputs, preambleSize: Int = 25): Long {
        val previousTaskSolution = Day9Task1().solve(forInputs, preambleSize)
        var startIndex = 0
        while (startIndex in forInputs.indices) {
            try {
                return processingSubsetsWithStartingIndex(previousTaskSolution, forInputs, startIndex)
            } catch (t: SolutionNotFound) {
                startIndex += 1
            }
        }
        throw SolutionNotFound()
    }
}