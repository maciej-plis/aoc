import commons.readResourceFile
import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day15Test {

    private val day15 = Day15()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-15/part-1-test").readText()

        val output = day15.solvePart1(input)

        assertEquals(1320, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-15/full").readText()

        val output = day15.solvePart1(input)

        assertEquals(507291, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-15/part-2-test").readText()

        val output = day15.solvePart2(input)

        assertEquals(145, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-15/full").readText()

        val output = day15.solvePart2(input)

        assertEquals(296921, output)
    }
}