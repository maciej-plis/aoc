import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day22Test {

    private val day22 = Day22()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 22)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 22, "part-1-test").readText()

        val output = day22.solvePart1(input)

        assertEquals(-1, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 22, "full").readText()

        val output = day22.solvePart1(input)

        assertEquals(-1, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 22, "part-2-test").readText()

        val output = day22.solvePart2(input)

        assertEquals(-1, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 22, "full").readText()

        val output = day22.solvePart2(input)

        assertEquals(-1, output)
    }
}
