import commons.readResourceFile
import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day21Test {

    private val day21 = Day21()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-21/part-1-test").readText()

        val output = day21.solvePart1(input)

        assertEquals(42, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-21/full").readText()

        val output = day21.solvePart1(input)

        assertEquals(3709, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-21/part-2-test").readText()

        val output = day21.solvePart2(input)

        assertEquals(-1, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-21/full").readText()

        val output = day21.solvePart2(input)

        assertEquals(-1, output)
    }
}