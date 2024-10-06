import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day7Test {

    private val day7 = Day7()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 7)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 7, "part-1-test").readText()

        val output = day7.solvePart1(input)

        assertEquals(6440, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 7, "full").readText()

        val output = day7.solvePart1(input)

        assertEquals(250370104, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 7, "part-2-test").readText()

        val output = day7.solvePart2(input)

        assertEquals(5905, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 7, "full").readText()

        val output = day7.solvePart2(input)

        assertEquals(251735672, output)
    }
}