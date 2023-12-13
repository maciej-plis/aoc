private val DIGITS = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
private val TEXT_DIGITS = mapOf(
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

internal class Day1 {

    fun solvePart1(input: String): Int {
        return input.lineSequence().sumOf {
            val first = it.first(Char::isDigit)
            val last = it.last(Char::isDigit)
            return@sumOf "$first$last".toInt()
        }
    }

    fun solvePart2(input: String): Int {
        return input.lineSequence().sumOf {
            val first = it.findAnyOf(DIGITS + TEXT_DIGITS.keys)?.second?.textToDigit() ?: error("No first digit found")
            val last = it.findLastAnyOf(DIGITS + TEXT_DIGITS.keys)?.second?.textToDigit() ?: error("No last digit found")
            return@sumOf "$first$last".toInt()
        }
    }

    private fun String.textToDigit() = first().digitToIntOrNull() ?: TEXT_DIGITS[this]
}