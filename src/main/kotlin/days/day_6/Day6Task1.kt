package days.day_6

class Day6Task1 {

    fun solution(): Int {
        return Day6Inputs.inputs.fold(0) { totalQuestions, input ->
            totalQuestions + input.data.flatten().toSet().count()
        }
    }
}