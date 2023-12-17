import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day17Test {

    private val day17 = Day17()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-17/part-1-test").readText()

        val output = day17.solvePart1(input)

        assertEquals(102, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-17/full").readText()

        val output = day17.solvePart1(input)

        assertEquals(791, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-17/part-2-test").readText()

        val output = day17.solvePart2(input)

        assertEquals(71, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-17/full").readText()

        val output = day17.solvePart2(input)

        assert(output > 899) { "Your answer is too low" }
        assertEquals(900, output)
    }
}