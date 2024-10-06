import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day6Test {

    private val day6 = Day6()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 6)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 6, "part-1-test").readText()

        val output = day6.solvePart1(input)

        assertEquals(288, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 6, "full").readText()

        val output = day6.solvePart1(input)

        assertEquals(2449062, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 6, "part-2-test").readText()

        val output = day6.solvePart2(input)

        assertEquals(71503, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 6, "full").readText()

        val output = day6.solvePart2(input)

        assertEquals(33149631, output)
    }
}