import kotlin.math.nextDown
import kotlin.math.nextUp
import kotlin.math.pow
import kotlin.math.sqrt

internal class Day6 {

    fun solvePart1(input: String): Long {
        val times = input.lines()[0].splitByWs().drop(1).toLong()
        val distances = input.lines()[1].splitByWs().drop(1).toLong()

        return times.zip(distances)
            .map { (time, distance) -> solveEquation(time, distance) }
            .product()
    }

    fun solvePart2(input: String): Long {
        val time = input.lines()[0].splitByWs().drop(1).joinToString("").toLong()
        val distance = input.lines()[1].splitByWs().drop(1).joinToString("").toLong()

        return solveEquation(time, distance)
    }

    fun solveEquation(time: Long, distance: Long): Long {
        val deltaSqrt = sqrt(time.toDouble().pow(2) - 4 * distance)
        val x1 = (time - deltaSqrt) / 2
        val x2 = (time + deltaSqrt) / 2
        return (x1.nextUp().ceil().toLong()..x2.nextDown().floor().toLong()).size
    }
}