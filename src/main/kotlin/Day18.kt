import commons.Direction
import commons.Direction.*
import commons.LongVector2
import commons.splitByWs

internal class Day18 {

    private data class Command(val direction: Direction, val times: Int)

    fun solvePart1(input: String) = solve(input, this::mapToCommandPart1)

    fun solvePart2(input: String) = solve(input, this::mapToCommandPart2)

    private fun solve(input: String, commandMapper: (String) -> Command): Long {
        val startingPos = LongVector2(0, 0)
        val commands = input.lineSequence().map { commandMapper(it) }

        val boundaries = commands.sumOf { it.times }
        val edges = commands
            .fold(listOf(startingPos)) { acc, command -> acc + acc.last().manyTo(command.times, command.direction) }
            .reversed()

        val shoelanceArea = edges.zipWithNext().sumOf { (x1, x2) -> (x1.x * x2.y) - (x1.y * x2.x) } / 2L
        return shoelanceArea + boundaries / 2 + 1
    }

    private fun mapToCommandPart1(line: String): Command {
        val (directionInput, timesInput) = line.splitByWs()
        val direction = parseDirection(directionInput)
        val times = timesInput.toInt()
        return Command(direction, times)
    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun mapToCommandPart2(line: String): Command {
        val (_, _, colorInput) = line.splitByWs()
        val hex = colorInput.drop(2).dropLast(1)
        val direction = parseDirection(hex.last().toString())
        val times = hex.dropLast(1).hexToInt()
        return Command(direction, times)
    }

    private fun parseDirection(symbol: String) = when (symbol) {
        "U", "3" -> NORTH
        "R", "0" -> EAST
        "D", "1" -> SOUTH
        "L", "2" -> WEST
        else -> error("Invalid direction symbol")
    }
}