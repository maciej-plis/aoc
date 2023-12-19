import commons.readResourceFile
import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day1Test {

    private val day1 = Day1()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-1/part-1-test").readText()

        val output = day1.solvePart1(input)

        assertEquals(142, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-1/full").readText()

        val output = day1.solvePart1(input)

        assertEquals(54951, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-1/part-2-test").readText()

        val output = day1.solvePart2(input)

        assertEquals(281, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-1/full").readText()

        val output = day1.solvePart2(input)

        assertEquals(55218, output)
    }
}