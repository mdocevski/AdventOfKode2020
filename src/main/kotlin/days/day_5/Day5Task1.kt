package days.day_5

class Day5Task1 {

    fun solution(): Int{
       return Day5Inputs.inputs.maxOf { it.third }
    }
}