import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day11Test {

    private val day11 = Day11()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 11)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 11, "part-1-test").readText()

        val output = day11.solvePart1(input)

        assertEquals(374, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 11, "full").readText()

        val output = day11.solvePart1(input)

        assertEquals(9647174, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 11, "part-2-test").readText()

        val output = day11.solvePart2(input)

        assertEquals(82000210L, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 11, "full").readText()

        val output = day11.solvePart2(input)

        assertEquals(377318892554L, output)
    }
}