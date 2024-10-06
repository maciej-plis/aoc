import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day16Test {

    private val day16 = Day16()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 16)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 16, "part-1-test").readText()

        val output = day16.solvePart1(input)

        assertEquals(46, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 16, "full").readText()

        val output = day16.solvePart1(input)

        assertEquals(7060, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 16, "part-2-test").readText()

        val output = day16.solvePart2(input)

        assertEquals(51, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 16, "full").readText()

        val output = day16.solvePart2(input)

        assertEquals(7493, output)
    }
}