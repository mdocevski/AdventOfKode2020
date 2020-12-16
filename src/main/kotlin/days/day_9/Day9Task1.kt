package days.day_9

class Day9Task1 {

    val inputs = Day9Inputs.inputs

    private fun processInput(inputs: List<Long>, currentInputIndex: Int, preambleSize: Int): Long {
        if (currentInputIndex == inputs.size - 1) {
            // Shouldn't happen under task conditions, but need a fallback terminal condition
            return inputs[currentInputIndex]
        }
        return if (currentInputIndex >= preambleSize) {
            val preamble = inputs.subList(currentInputIndex - preambleSize, currentInputIndex)
            val preamblePairSums = preamble.flatMapIndexed { index: Int, leftPreambleElement: Long ->
                preamble.slice(index + 1 until preamble.size).map { rightPreambleElement ->
                    leftPreambleElement + rightPreambleElement
                }
            }
            if (inputs[currentInputIndex] in preamblePairSums) {
                processInput(inputs, currentInputIndex + 1, preambleSize)
            } else {
                inputs[currentInputIndex]
            }
        } else {
            processInput(inputs, currentInputIndex + 1, preambleSize)
        }
    }

    fun solve(forInputs: List<Long> = inputs, preambleSize: Int = 25): Long {
        return processInput(forInputs, 0, preambleSize)
    }
}