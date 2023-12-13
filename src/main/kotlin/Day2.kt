private val GAME_ID_REGEX = """Game (?<gameId>\d+): """.toRegex()
private val PLAY_REGEX = """(((?<red>\d+) red|(?<green>\d+) green|(?<blue>\d+) blue),?\s?){1,3}""".toRegex()

private data class Play(val red: Int?, val green: Int?, val blue: Int?)
private data class Game(val id: Int, val plays: List<Play>)

internal class Day2 {

    fun solvePart1(input: String): Int {
        return input.lineSequence()
            .map(this::parseGame)
            .filter { gamePlaysDontExceedLimit(it, 12, 13, 14) }
            .sumOf { it.id }
    }

    fun solvePart2(input: String): Int {
        return input.lineSequence()
            .map { parseGame(it).plays }
            .sumOf {
                it.maxOf { it.red ?: 1 } *
                it.maxOf { it.green ?: 1 } *
                it.maxOf { it.blue ?: 1 }
            }
    }

    private fun gamePlaysDontExceedLimit(game: Game, redLimit: Int, greenLimit: Int, blueLimit: Int) = game.plays.all {
        (it.red ?: 0) <= redLimit &&
        (it.green ?: 0) <= greenLimit &&
        (it.blue ?: 0) <= blueLimit
    }

    private fun parseGame(line: String) = Game(
        GAME_ID_REGEX.findValue(line, "gameId")?.toInt() ?: error("Game id not found"),
        PLAY_REGEX.findValues(line, setOf("red", "green", "blue")).map { Play(it["red"]?.toInt(), it["green"]?.toInt(), it["blue"]?.toInt()) }
    )
}