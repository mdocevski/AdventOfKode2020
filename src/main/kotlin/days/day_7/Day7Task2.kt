package days.day_7

class Day7Task2 {

    fun solution(): Int {
        val input = Day7Inputs.inputs
        val bagContents = mutableMapOf<String, Int>()
        return computeContentSize(input, "shiny gold", bagContents)
    }

    private fun computeContentSize(inputs: List<Input>, bag: String, contentCash: MutableMap<String, Int>): Int {
        if (contentCash.containsKey(bag).not()) {
            contentCash[bag] = inputs.first { it.topBag == bag }.component2().fold(0) { contentSize, subBag ->
                val subBagContentSize = computeContentSize(inputs, subBag.first, contentCash)
                contentSize + subBag.second *  (1 + subBagContentSize)
            }
        }
        return contentCash[bag]!!
    }
}