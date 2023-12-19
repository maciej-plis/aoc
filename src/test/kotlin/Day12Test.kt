import commons.readResourceFile
import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day12Test {

    private val day12 = Day12()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-12/part-1-test").readText()

        val output = day12.solvePart1(input)

        assertEquals(21, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-12/full").readText()

        val output = day12.solvePart1(input)

        assertEquals(7173, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-12/part-2-test").readText()

        val output = day12.solvePart2(input)

        assertEquals(525152, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-12/full").readText()

        val output = day12.solvePart2(input)

        assertEquals(29826669191291, output)
    }
}