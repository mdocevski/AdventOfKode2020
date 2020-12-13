package days.day_5

class Day5Task2 {

    fun solution(): Int {
        val inputs = Day5Inputs.inputs.map { it.third }
        val rangeOfPossibleTickets = inputs.minOrNull()!!..inputs.maxOrNull()!!
        val missingTickets = rangeOfPossibleTickets.toList().filter {
            !inputs.contains(it)
        }
        return missingTickets.first {
            missingTickets.contains(it - 1).not() && missingTickets.contains(it + 1).not()
        }
    }
}