package days.day_6

class Day6Task2 {

    fun solution(): Int {
        return Day6Inputs.inputs.fold(0) { totalQuestions, input ->
            totalQuestions + input.data.flatten().toSet().count { answer ->
                input.data.all { personsAnswers -> personsAnswers.contains(answer) }
            }
        }
    }
}