package days.day_2

class Day2Task1 {
    fun solution(): Int {
        val inputs = Day2Inputs.inputs
        return inputs.count { passwordInput ->
            val characterRepetitionsInPassword =
                passwordInput.password.toCharArray().fold(mutableMapOf<Char, Int>()) { countMap, character ->
                    countMap.compute(character) { _, oldValue ->
                        (oldValue ?: 0) + 1
                    }
                    countMap
                }
            characterRepetitionsInPassword[passwordInput.passwordPolicyCharacter] in
                    passwordInput.passwordPolicyNumber1..passwordInput.passwordPolicyNumber2
        }
    }
}