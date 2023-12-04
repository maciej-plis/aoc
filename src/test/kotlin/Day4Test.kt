import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day4Test {

    private val day4 = Day4()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-4/part-1-test").readText()

        val output = day4.solvePart1(input)

        assertEquals(13, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-4/full").readText()

        val output = day4.solvePart1(input)

        assertEquals(24175, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-4/part-2-test").readText()

        val output = day4.solvePart2(input)

        assertEquals(30, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-4/full").readText()

        val output = day4.solvePart2(input)

        assertEquals(18846301, output)
    }
}