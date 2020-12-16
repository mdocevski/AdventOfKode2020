package days.day_8

class Day8Task2 {

    val inputs = Day8Inputs.inputs

    sealed class Errors : Throwable() {
        class InfiniteLoop : Errors()
    }

    private fun processNextInput(
        currentIndex: Int,
        visitedIndexes: Set<Int>,
        processingCorrection: Boolean,
        accumulator: Long
    ): Long {
        if (currentIndex in visitedIndexes) {
            // Got caught in a loop
            throw Errors.InfiniteLoop()
        }
        if (currentIndex == inputs.size) {
            // Correctly processed the inputs, next instruction is out of bounds by 1
            return accumulator
        }

        val currentInput = inputs[currentIndex]
        when (currentInput.action) {
            Input.Instruction.AddToAccumulator -> {
                return processNextInput(
                    currentIndex = currentIndex + 1,
                    visitedIndexes = visitedIndexes + setOf(currentIndex),
                    processingCorrection = processingCorrection,
                    accumulator = accumulator + currentInput.value
                )
            }
            Input.Instruction.NoOperation -> {
                if (processingCorrection) {
                    return processNextInput(
                        currentIndex = currentIndex + 1,
                        visitedIndexes = visitedIndexes + setOf(currentIndex),
                        processingCorrection = processingCorrection,
                        accumulator = accumulator
                    )
                } else {
                    try {
                        // Try the regular path
                        return processNextInput(
                            currentIndex = currentIndex + 1,
                            visitedIndexes = visitedIndexes + setOf(currentIndex),
                            processingCorrection = false,
                            accumulator = accumulator
                        )
                    } catch (t: Errors.InfiniteLoop) {
                        // Regular path failed, try to correct it, do a jump operation instead
                        return processNextInput(
                            currentIndex = currentIndex + currentInput.value,
                            visitedIndexes = visitedIndexes + setOf(currentIndex),
                            processingCorrection = true,
                            accumulator = accumulator
                        )
                    }
                }
            }
            Input.Instruction.Jump -> {
                if (processingCorrection) {
                    return processNextInput(
                        currentIndex = currentIndex + currentInput.value,
                        visitedIndexes = visitedIndexes + setOf(currentIndex),
                        processingCorrection = processingCorrection,
                        accumulator = accumulator
                    )
                } else {
                    try {
                        // Try the regular path
                        return processNextInput(
                            currentIndex = currentIndex + currentInput.value,
                            visitedIndexes = visitedIndexes + setOf(currentIndex),
                            processingCorrection = false,
                            accumulator = accumulator
                        )
                    } catch (t: Errors.InfiniteLoop) {
                        // Regular path failed, try to correct it, do a no-op operation instead
                        return processNextInput(
                            currentIndex = currentIndex + 1,
                            visitedIndexes = visitedIndexes + setOf(currentIndex),
                            processingCorrection = true,
                            accumulator = accumulator
                        )
                    }
                }
            }
        }
    }

    fun solve(): Long {
        return processNextInput(
            currentIndex = 0,
            visitedIndexes = setOf(),
            processingCorrection = false,
            accumulator = 0L
        )
    }
}