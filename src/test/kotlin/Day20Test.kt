import commons.readResourceFile
import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day20Test {

    private val day20 = Day20()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-20/part-1-test").readText()

        val output = day20.solvePart1(input)

        assertEquals(11687500, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-20/full").readText()

        val output = day20.solvePart1(input)

        assertEquals(818723272, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-20/part-2-test").readText()

        val output = day20.solvePart2(input)

        assertEquals(4, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-20/full").readText()

        val output = day20.solvePart2(input)

        assertEquals(243902373381257, output)
    }
}