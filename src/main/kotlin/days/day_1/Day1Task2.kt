package days.day_1

class Day1Task2 {

    fun solution(): Int {
        val inputs = Day1Inputs.inputs
        val allTriples = inputs.flatMapIndexed { index1, item1 ->
            inputs.slice((index1 + 1) until inputs.size).flatMapIndexed { index2, item2 ->
                inputs.slice((index2 + 1) until inputs.size).map { item3 ->
                    Triple(item1.toInt(), item2.toInt(), item3.toInt())
                }
            }
        }
        val winningTriple = allTriples.first { it.toList().fold(0) { x, y -> x + y } == 2020 }
        return winningTriple.toList().fold(1) { x, y -> x * y }
    }
}