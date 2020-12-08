package days.day_2

class Day2Task2 {
    fun solution(): Int {
        val inputs = Day2Inputs.inputs
        return inputs.count { passwordInput ->
            (passwordInput.password[passwordInput.passwordPolicyNumber1 - 1] == passwordInput.passwordPolicyCharacter) xor
                    (passwordInput.password[passwordInput.passwordPolicyNumber2 - 1] == passwordInput.passwordPolicyCharacter)
        }
    }
}