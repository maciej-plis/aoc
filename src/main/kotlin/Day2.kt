import Day2.Color.*

internal class Day2 {

    fun solvePart1(input: String): Int {
        return input.lines()
                .map(this::parseGames)
                .filter {
                    it.second.all {
                        (it[RED] ?: 0) <= RED_CONSTRAINT && (it[GREEN] ?: 0) <= GREEN_CONSTRAINT && (it[BLUE]
                                ?: 0) <= BLUE_CONSTRAINT
                    }
                }
                .sumOf { it.first }
    }

    fun solvePart2(input: String): Int {
        return input.lines()
                .map { parseGames(it).second }
                .map {
                    val red = it.maxOf { it[RED] ?: 1 }
                    val green = it.maxOf { it[GREEN] ?: 1 }
                    val blue = it.maxOf { it[BLUE] ?: 1 }
                    return@map red * green * blue
                }
                .sum()
    }

    private fun parseGames(line: String): Pair<Int, List<Map<Color, Int>>> {
        val lineElements = line.split(": ")
        val gameId = lineElements[0].split(" ")[1].toInt()
        val draws = lineElements[1].split("; ")
                .map { it.split(", ").map { it.split(" ") }.associate { Color.valueOf(it[1].uppercase()) to it[0].toInt() } }
        return gameId to draws
    }

    enum class Color {
        RED, GREEN, BLUE
    }

    companion object {
        const val RED_CONSTRAINT = 12
        const val GREEN_CONSTRAINT = 13
        const val BLUE_CONSTRAINT = 14
    }
}