import commons.readResourceFile
import org.junit.jupiter.api.Test
import kotlin.io.path.readText
import kotlin.test.assertEquals

internal class Day19Test {

    private val day19 = Day19()

    @Test
    fun part1_testInput() {
        val input = readResourceFile("day-19/part-1-test").readText()

        val output = day19.solvePart1(input)

        assertEquals(19114, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readResourceFile("day-19/full").readText()

        val output = day19.solvePart1(input)

        assertEquals(401674, output)
    }

    @Test
    fun part2_testInput() {
        val input = readResourceFile("day-19/part-2-test").readText()

        val output = day19.solvePart2(input)

        assertEquals(167409079868000, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readResourceFile("day-19/full").readText()

        val output = day19.solvePart2(input)

        assertEquals(134906204068564, output)
    }
}