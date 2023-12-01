internal class Day1 {

    fun solvePart1(input: String): Int {
        return input.lines().sumOf {
            val first = it.first(Char::isDigit)
            val last = it.last(Char::isDigit)
            return@sumOf "$first$last".toInt()
        }
    }

    fun solvePart2(input: String): Int {
        return input.lines().sumOf {
            val first = it.findAnyOf(digits.keys, ignoreCase = true)?.second?.textToDigit()!!
            val last = it.findLastAnyOf(digits.keys, ignoreCase = true)?.second?.textToDigit()!!
            return@sumOf "$first$last".toInt()
        }
    }

    private fun String.textToDigit() = digits[this]

    companion object {
        val digits = mapOf(
            "1" to 1,
            "2" to 2,
            "3" to 3,
            "4" to 4,
            "5" to 5,
            "6" to 6,
            "7" to 7,
            "8" to 8,
            "9" to 9,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )
    }
}