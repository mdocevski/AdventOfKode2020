package days.day_4

class Day4Task2 {

//    byr (Birth Year) - four digits; at least 1920 and at most 2002.
//    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
//    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
//    hgt (Height) - a number followed by either cm or in:
//    If cm, the number must be at least 150 and at most 193.
//    If in, the number must be at least 59 and at most 76.
//    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
//    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
//    pid (Passport ID) - a nine-digit number, including leading zeroes.
//    cid (Country ID) - ignored, missing or not.

    fun solution(): Int {
        return Day4Inputs.inputs.count { input ->
            val containsRequiredFields = input.data.size == 8
                    || (input.data.size == 7 && !input.containsDatum(Input.DatumType.CountryID))
            return@count containsRequiredFields && Input.DatumType.values().all { datumType ->
                if(datumType == Input.DatumType.CountryID) return@all true
                print("$datumType ")
                datumType.isValid(input.getDatum(datumType).also { print("$it ") }).also { print("$it ") }.also { println() }
            }.also { println() }
        }
    }
}