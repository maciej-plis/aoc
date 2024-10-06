import commons.*
import java.util.*
import java.util.Comparator.comparingInt

internal class Day21 {

    fun solvePart1(input: String): Int {
        val map = input.to2DCharArray()

        val steps = 64
        val startingPoint = map.locate('S') ?: error("Starting point not found")

        val stepsMap = map.toStepsMap(startingPoint)
        return stepsMap.countSteps(steps)
    }

    fun solvePart2(input: String): Long {
        val map = input.to2DCharArray()

        val quadrantsSize = 5
//        val steps = 26_501_365
        val steps = 50
        val startingPoint = map.locate('S') ?: error("Starting point not found")

        val largerMap = map.duplicate(quadrantsSize, quadrantsSize)
        val largerMapStartingPoint = Vector2(startingPoint.x + map.size * (quadrantsSize / 2), startingPoint.y + map.first().size * (quadrantsSize / 2))
        val largerStepsMap = largerMap.toStepsMap(largerMapStartingPoint)
        val quadrants = largerStepsMap.splitIntoQuadrants(quadrantsSize, quadrantsSize)

        val topLeft = quadrants[0][0]
        val topCenterLeft = quadrants[0][1]
        val topCenter = quadrants[0][2]
        val topCenterRight = quadrants[0][3]
        val topRight = quadrants[0][4]

        val leftCenterTop = quadrants[1][0]
        val leftCenter = quadrants[2][0]
        val leftCenterBottom = quadrants[3][0]

        val rightCenterTop = quadrants[1][4]
        val rightCenter = quadrants[2][4]
        val rightCenterBottom = quadrants[3][4]

        val bottomLeft = quadrants[4][0]
        val bottomCenterLeft = quadrants[4][1]
        val bottomCenter = quadrants[4][2]
        val bottomCenterRight = quadrants[4][3]
        val bottomRight = quadrants[4][4]

        val corner = listOf(topLeft to 22, topRight to 22, bottomRight to 22, bottomLeft to 22)
        val outer = mutableListOf(
            topCenterLeft to 11, topCenter to 11, topCenterRight to 11,
            leftCenterTop to 11, leftCenter to 11, leftCenterBottom to 11,
            rightCenterTop to 11, rightCenter to 11, rightCenterBottom to 11,
            bottomCenterLeft to 11, bottomCenter to 11, bottomCenterRight to 11
        )

        var count = quadrants.sumOf { it.sumOf { it.countSteps(steps) } }.toLong()
        var iter = 1
        while (true) {
            outer.addAll(
                listOf(
                    topLeft to 11, topLeft to 11,
                    topRight to 11, topRight to 11,
                    bottomLeft to 11, bottomLeft to 11,
                    bottomRight to 11, bottomRight to 11
                )
            )
            count += outer.sumOf { (quadrant, inc) -> quadrant.countSteps(steps, inc * iter) }
            count += corner.sumOf { (quadrant, inc) -> quadrant.countSteps(steps, inc * iter) }
            if (outer.all { (quadrant, inc) -> quadrant.max() + inc * iter > steps } &&
                corner.all { (quadrant, inc) -> quadrant.max() + (inc * iter) > steps }) break

            iter++
        }

        return count
    }

    private fun IntArray2D.max() = maxOf { it.maxOf { it } }
    private fun IntArray2D.min() = minOf { it.filter { it >= 0 }.minOf { it } }
    private fun IntArray2D.diff() = max() - min()

    private fun IntArray2D.countSteps(upTo: Int): Int {
        var count = 0
        for (x in indices) {
            for (y in first().indices) {
                if (get(x, y) in 0..upTo && (get(x, y) % 2) == upTo % 2) count++
            }
        }
        return count
    }

    private fun IntArray2D.countSteps(upTo: Int, base: Int): Int {
        var count = 0
        for (x in indices) {
            for (y in first().indices) {
                if (get(x, y) > 0 && (get(x, y) + base) in 0..upTo && ((get(x, y) + base) % 2) == upTo % 2) {
                    count++
                }
            }
        }
        return count
    }

    private fun Vector2.getNextPossibleSteps(map: Array<CharArray>, visited: Set<Vector2>) = adjacent()
        .filter { it in map && it !in visited && map.getOrNull(it) != '#' }
        .toSet()

    private fun CharArray2D.toStepsMap(startingPoint: Vector2): IntArray2D {
        val arr = Array(size) { IntArray(first().size) { -1 } }
        val visited = hashSetOf(startingPoint)
        val queue = PriorityQueue<Pair<Int, Vector2>>(comparingInt { it.first }).apply { add(0 to startingPoint) }
        while (queue.isNotEmpty()) {
            val (step, position) = queue.remove()
            arr[position] = step
            queue.addAll(position.getNextPossibleSteps(this, visited).onEach { visited += it }.map { step + 1 to it })
        }
        return arr
    }

    private fun CharArray2D.duplicate(rows: Int, cols: Int): CharArray2D {
        val arr = Array(size * rows) { CharArray(first().size * cols) }
        for (x in arr.indices) {
            for (y in arr.first().indices) {
                arr[x][y] = get(x % size, y % first().size)
            }
        }
        return arr
    }

    private fun IntArray2D.splitIntoQuadrants(rows: Int, cols: Int): Array<Array<IntArray2D>> {
        val arr = Array(rows) { Array(cols) { Array(size / rows) { IntArray(first().size / cols) } } }
        for (qX in 0..<rows) {
            for (qY in 0..<cols) {
                val quadrant = arr[qX][qY]
                for (x in quadrant.indices) {
                    for (y in quadrant.first().indices) {
                        quadrant[x][y] = get(qX * quadrant.size + x, qY * quadrant.first().size + y)
                    }
                }
            }
        }
        return arr
    }
}
