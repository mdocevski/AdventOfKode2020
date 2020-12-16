package days.day_8

class Day8Task1 {

    val inputs = Day8Inputs.inputs
    var currentIndex = 0
    var accumulator = 0L
    val visitedIndexes = mutableSetOf<Int>()

    fun canProcessNextInput(): Boolean = !visitedIndexes.contains(currentIndex)

    fun processNextInput() {
        val nextInput = inputs[currentIndex]
        visitedIndexes.add(currentIndex)
        when (nextInput.action) {
            Input.ActionType.Acc -> {
                currentIndex += 1
                accumulator += nextInput.value
            }
            Input.ActionType.Nop -> {
                currentIndex += 1
            }
            Input.ActionType.Jmp -> {
                currentIndex += nextInput.value
            }
        }
    }

    fun solve(): Long {
        while (canProcessNextInput()) {
            processNextInput()
        }
        return accumulator
    }
}