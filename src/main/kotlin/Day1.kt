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
            val first = it.findAnyOf(digits + textDigits.keys)?.second?.textToDigit()!!
            val last = it.findLastAnyOf(digits + textDigits.keys)?.second?.textToDigit()!!
            return@sumOf "$first$last".toInt()
        }
    }

    private fun String.textToDigit() = if(length == 1 && first().isDigit()) first().digitToInt() else textDigits[this]
    companion object {
        val digits = listOf("1","2","3","4","5","6","7","8","9")
        val textDigits = mapOf(
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