internal class Day3 {

    data class Match<T>(val lineIndex: Int, val range: IntRange, val value: T)

    fun solvePart1(input: String): Int {
        val lines = input.lines()
        return lines
            .flatMapIndexed { lineIndex, line -> line.findAll(NUMBER_REGEX).map { Match(lineIndex, it.range, it.value) } }
            .filter { match -> match.range.any { lines.anyAdjacent(match.lineIndex, it, SYMBOLS::contains) } }
            .sumOf { it.value.toInt() }
    }

    fun solvePart2(input: String): Int {
        val lines = input.lines()
        return lines
            .flatMapIndexed { lineIndex, line -> line.findAll(ASTERISK_REGEX).map { Match(lineIndex, it.range, it.value) } }
            .map { match -> lines.getAdjacentNumbers(match.lineIndex, match.range.first) }
            .filter { it.size == 2 }
            .sumOf { it.product() }
    }

    private fun List<String>.anyAdjacent(x: Int, y: Int, condition: (Char) -> Boolean): Boolean {
        for (i in x - 1..x + 1) {
            for (j in y - 1..y + 1) {
                val c = this.getOrNull(i)?.getOrNull(j) ?: continue
                if (condition(c)) return true
            }
        }
        return false
    }

    private fun List<String>.getAdjacentNumbers(x: Int, y: Int): List<Int> {
        val numbers = mutableListOf<Int>()
        for (i in x - 1..x + 1) {
            if (this.getOrNull(i)?.getFullNumber(y)?.apply(numbers::add) != null) continue
            this.getOrNull(i)?.getFullNumber(y - 1)?.let(numbers::add)
            this.getOrNull(i)?.getFullNumber(y + 1)?.let(numbers::add)
        }
        return numbers
    }

    private fun String.getFullNumber(index: Int): Int? {
        var start = index
        var end = index + 1
        if (getOrNull(start)?.isDigit() != true) return null
        while (getOrNull(start - 1)?.isDigit() == true) start--
        while (getOrNull(end)?.isDigit() == true) end++
        return substring(start, end).toInt()
    }

    companion object {
        val NUMBER_REGEX = "\\d+".toRegex()
        val ASTERISK_REGEX = "\\*".toRegex()
        val SYMBOLS = setOf('@', '#', '$', '%', '&', '*', '-', '+', '=', '/')
    }
}