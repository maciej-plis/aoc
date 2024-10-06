import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day19Test {

    private val day19 = Day19()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 19)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 19, "part-1-test").readText()

        val output = day19.solvePart1(input)

        assertEquals(19114, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 19, "full").readText()

        val output = day19.solvePart1(input)

        assertEquals(401674, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 19, "part-2-test").readText()

        val output = day19.solvePart2(input)

        assertEquals(167409079868000, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 19, "full").readText()

        val output = day19.solvePart2(input)

        assertEquals(134906204068564, output)
    }
}