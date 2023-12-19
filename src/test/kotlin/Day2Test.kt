import commons.readResourceFile
import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day2Test {

    private val day2 = Day2()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-2/part-1-test").readText()

        val output = day2.solvePart1(input)

        assertEquals(8, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-2/full").readText()

        val output = day2.solvePart1(input)

        assertEquals(2776, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-2/part-2-test").readText()

        val output = day2.solvePart2(input)

        assertEquals(2286, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-2/full").readText()

        val output = day2.solvePart2(input)

        assertEquals(68638, output)
    }
}