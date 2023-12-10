import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day10Test {

    private val day10 = Day10()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-10/part-1-test").readText()

        val output = day10.solvePart1(input)

        assertEquals(8, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-10/full").readText()

        val output = day10.solvePart1(input)

        assertEquals(7173, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-10/part-2-test").readText()

        val output = day10.solvePart2(input)

        assertEquals(10, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-10/full").readText()

        val output = day10.solvePart2(input)

        assertEquals(291, output)
    }
}