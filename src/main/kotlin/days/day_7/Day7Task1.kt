package days.day_7

class Day7Task1 {

    fun solution(): Int {
        val inputs = Day7Inputs.inputs
        var toProcess = listOf("shiny gold")
        val processedBags = mutableSetOf<String>()
        do {
            toProcess = inputs.filter { input ->
                input.bagsCount.map { it.first }.any { it in toProcess }
            }.map { it.topBag }
                .filter {
                    processedBags.contains(it).not()
                }

            processedBags.addAll(toProcess)
        } while (toProcess.isNotEmpty())

        return processedBags.size
    }
}