package days.day_4

class Day4Task1 {

    fun solution(): Int {
        val input = Day4Inputs.inputs
        return input.count { passport ->
            passport.data.size == 8 ||
                    (passport.data.size == 7 && passport.data.none { datum -> datum.contains("cid") })
        }
    }
}