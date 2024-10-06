import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day12Test {

    private val day12 = Day12()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 12)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 12, "part-1-test").readText()

        val output = day12.solvePart1(input)

        assertEquals(21, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 12, "full").readText()

        val output = day12.solvePart1(input)

        assertEquals(7173, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 12, "part-2-test").readText()

        val output = day12.solvePart2(input)

        assertEquals(525152, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 12, "full").readText()

        val output = day12.solvePart2(input)

        assertEquals(29826669191291, output)
    }
}