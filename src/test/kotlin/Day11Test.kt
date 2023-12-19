import commons.readResourceFile
import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day11Test {

    private val day11 = Day11()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-11/part-1-test").readText()

        val output = day11.solvePart1(input)

        assertEquals(374, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-11/full").readText()

        val output = day11.solvePart1(input)

        assertEquals(9647174, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-11/part-2-test").readText()

        val output = day11.solvePart2(input)

        assertEquals(82000210L, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-11/full").readText()

        val output = day11.solvePart2(input)

        assertEquals(377318892554L, output)
    }
}