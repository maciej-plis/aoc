import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day13Test {

    private val day13 = Day13()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-13/part-1-test").readText()

        val output = day13.solvePart1(input)

        assertEquals(405, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-13/full").readText()

        val output = day13.solvePart1(input)

        assertEquals(28651, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-13/part-2-test").readText()

        val output = day13.solvePart2(input)

        assertEquals(400, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-13/full").readText()

        val output = day13.solvePart2(input)

        assertEquals(25450, output)
    }
}