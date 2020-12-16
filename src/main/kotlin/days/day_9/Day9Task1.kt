package days.day_9

class Day9Task1 {

    val inputs = Day9Inputs.inputs

    private fun processInput(currentInputIndex: Int): Long {
        if (currentInputIndex == inputs.size - 1) {
            // Shouldn't happen under task conditions, but need a fallback terminal condition
            return inputs[currentInputIndex]
        }
        return if (currentInputIndex >= 25) {
            val preamble = inputs.subList(currentInputIndex - 25, currentInputIndex)
            val preamblePairSums = preamble.flatMapIndexed { index: Int, leftPreambleElement: Long ->
                preamble.slice(index + 1 until preamble.size).map { rightPreambleElement ->
                    leftPreambleElement + rightPreambleElement
                }
            }
            if (inputs[currentInputIndex] in preamblePairSums) {
                processInput(currentInputIndex + 1)
            } else {
                inputs[currentInputIndex]
            }
        } else {
            processInput(currentInputIndex + 1)
        }
    }

    fun solve(): Long {
        return processInput(0)
    }
}