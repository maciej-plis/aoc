import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day14Test {

    private val day14 = Day14()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-14/part-1-test").readText()

        val output = day14.solvePart1(input)

        assertEquals(136, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-14/full").readText()

        val output = day14.solvePart1(input)

        assertEquals(108889, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-14/part-2-test").readText()

        val output = day14.solvePart2(input)

        assertEquals(64, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-14/full").readText()

        val output = day14.solvePart2(input)

        assertEquals(104671, output)
    }
}