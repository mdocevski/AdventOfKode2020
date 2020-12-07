package days.day_1

class Day1Task1 {

    fun solution(): Int {
        val inputs = Day1Inputs.inputs
        val allPairs = inputs.flatMapIndexed { index, item1 ->
            inputs.slice((index + 1) until inputs.size).map { item2 ->
                item1.toInt() to item2.toInt()
            }
        }
        val (left, right) = allPairs.first { (left, right) -> left + right == 2020 }
        return left * right
    }
}