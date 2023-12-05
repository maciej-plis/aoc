import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day5Test {

    private val day5 = Day5()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-5/part-1-test").readText()

        val output = day5.solvePart1(input)

        assertEquals(35L, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-5/full").readText()

        val output = day5.solvePart1(input)

        assertEquals(218513636L, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-5/part-2-test").readText()

        val output = day5.solvePart2(input)

        assertEquals(46L, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-5/full").readText()

        val output = day5.solvePart2(input)

        assertEquals(81956384L, output)
    }
}