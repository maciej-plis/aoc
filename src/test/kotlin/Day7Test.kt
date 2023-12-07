import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day7Test {

    private val day7 = Day7()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-7/part-1-test").readText()

        val output = day7.solvePart1(input)

        assertEquals(6440, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-7/full").readText()

        val output = day7.solvePart1(input)

        assertEquals(250370104, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-7/part-2-test").readText()

        val output = day7.solvePart2(input)

        assertEquals(5905, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-7/full").readText()

        val output = day7.solvePart2(input)

        assertEquals(251735672, output)
    }
}