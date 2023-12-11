internal class Day10 {

    data class Travel(val current: Pair<Int, Int>, val next: Pair<Int, Int>, val distance: Int)

    fun solvePart1(input: String): Int {
        val pipesMap = input.lines()
        val startingPoint = pipesMap.positionOf('S')
        var travels = buildList {
            startingPoint.above()
                .let { if (pipesMap.contains(it) && pipesMap.charAt(it) in START_TOP_CONNECTIONS) add(Travel(startingPoint, it, 0).goToNext(pipesMap)) }
            startingPoint.below()
                .let { if (pipesMap.contains(it) && pipesMap.charAt(it) in START_BOTTOM_CONNECTIONS) add(Travel(startingPoint, it, 0).goToNext(pipesMap)) }
            startingPoint.left()
                .let { if (pipesMap.contains(it) && pipesMap.charAt(it) in START_LEFT_CONNECTIONS) add(Travel(startingPoint, it, 0).goToNext(pipesMap)) }
            startingPoint.right()
                .let { if (pipesMap.contains(it) && pipesMap.charAt(it) in START_RIGHT_CONNECTIONS) add(Travel(startingPoint, it, 0).goToNext(pipesMap)) }
        }

        val pipeLoop = mutableSetOf(startingPoint)
        pipeLoop += travels.map { it.current }

        while (travels.map { it.current }.distinct().size != 1) {
            travels = travels.map { it.goToNext(pipesMap) }.onEach { pipeLoop.add(it.current) }
        }

        return travels.first().distance
    }

    fun solvePart2(input: String): Int {
        val pipesMap = input.lines()
        val startingPoint = pipesMap.positionOf('S')
        var travels = buildList {
            startingPoint.above()
                .let { if (pipesMap.contains(it) && pipesMap.charAt(it) in START_TOP_CONNECTIONS) add(Travel(startingPoint, it, 0).goToNext(pipesMap)) }
            startingPoint.below()
                .let { if (pipesMap.contains(it) && pipesMap.charAt(it) in START_BOTTOM_CONNECTIONS) add(Travel(startingPoint, it, 0).goToNext(pipesMap)) }
            startingPoint.left()
                .let { if (pipesMap.contains(it) && pipesMap.charAt(it) in START_LEFT_CONNECTIONS) add(Travel(startingPoint, it, 0).goToNext(pipesMap)) }
            startingPoint.right()
                .let { if (pipesMap.contains(it) && pipesMap.charAt(it) in START_RIGHT_CONNECTIONS) add(Travel(startingPoint, it, 0).goToNext(pipesMap)) }
        }

        val pipeLoop = mutableSetOf(startingPoint)
        pipeLoop += travels.map { it.current }

        while (travels.map { it.current }.distinct().size != 1) {
            travels = travels.map { it.goToNext(pipesMap) }.onEach { pipeLoop.add(it.current) }
        }

        var intersections = 0
        var count = 0

        for (i in pipesMap.indices) {
            for (j in pipesMap.first().indices) {
                var point = i to j
                intersections = 0
                if (point in pipeLoop) continue
                while (pipesMap.contains(point)) {
                    point = point.first to point.second + 1
                    if (point in pipeLoop && pipesMap.charAt(point) !in setOf('-', 'L', 'J')) intersections++
                }
                if (point == 6 to 14) println(pipesMap.charAt(6 to 14))
                if (intersections % 2 == 1) count++
            }
        }

        return count
    }

    fun Travel.goToNext(pipeMap: List<String>): Travel {
        val pipe = pipeMap[next.first][next.second]
        val (output1, output2) = pipe.getOutputs(next)
        val output = if (current == output1) output2 else output1
        return Travel(next, output, distance + 1)
    }

    fun Char.getOutputs(location: Pair<Int, Int>) = when {
        this == '|' -> location.above() to location.below()
        this == '-' -> location.left() to location.right()
        this == '7' -> location.left() to location.below()
        this == 'F' -> location.below() to location.right()
        this == 'J' -> location.left() to location.above()
        this == 'L' -> location.above() to location.right()
        else -> error("Unknown pipe type")
    }

    fun Pair<Int, Int>.above() = (first - 1) to second
    fun Pair<Int, Int>.below() = (first + 1) to second
    fun Pair<Int, Int>.left() = first to (second - 1)
    fun Pair<Int, Int>.right() = first to (second + 1)

    companion object {
        val START_TOP_CONNECTIONS = setOf('|', '7', 'F')
        val START_BOTTOM_CONNECTIONS = setOf('|', 'J', 'L')
        val START_LEFT_CONNECTIONS = setOf('-', 'L', 'F')
        val START_RIGHT_CONNECTIONS = setOf('-', 'J', '7')
    }
}