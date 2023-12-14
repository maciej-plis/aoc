import Direction.*

private const val ROUNDED_ROCK = 'O'
private const val CUBE_ROCK = '#'
private const val EMPTY_SPACE = '.'

private enum class Direction {
    NORTH, EAST, SOUTH, WEST
}

internal class Day14 {

    fun solvePart1(input: String): Int {
        val map = input.to2DCharArray()
        tiltMap(map, NORTH)
        return map.reversed()
            .mapIndexed { index, chars -> (index + 1) * chars.count { it == ROUNDED_ROCK } }
            .sum()
    }

    fun solvePart2(input: String): Int {
        val map = input.to2DCharArray()
        val mapCycles = mutableListOf(map.joinToString())
        val cycles = 1_000_000_000

        for (i in 1..cycles) {
            tiltMap(map, NORTH)
            tiltMap(map, WEST)
            tiltMap(map, SOUTH)
            tiltMap(map, EAST)

            val mapString = map.joinToString()
            if (mapCycles.contains(mapString)) break
            mapCycles += mapString
        }

        val startAt = mapCycles.indexOf(map.joinToString())
        val endAt = mapCycles.lastIndex
        val size = endAt - startAt + 1
        val resultIndex = (((cycles - startAt) % size) + size) % size + startAt

        return mapCycles[resultIndex].lines().reversed()
            .mapIndexed { index, line -> (index + 1) * line.count { it == ROUNDED_ROCK } }
            .sum()
    }

    private fun Array<CharArray>.joinToString(lineSeparator: String = "\n", itemSeparator: String = "") =
        map { it.joinToString(itemSeparator) }.joinToString(lineSeparator)

    private fun tiltMap(map: Array<CharArray>, direction: Direction) {
        val horizontalProgression = if (direction == SOUTH) map.indices.reversed() else map.indices
        val verticalProgression = if (direction == EAST) map.first().indices.reversed() else map.first().indices

        if (direction == EAST || direction == WEST) {
            for (x in horizontalProgression) {
                var freeTile = Vec2(x, verticalProgression.first)
                for (y in verticalProgression) {
                    if (map[x][y] == ROUNDED_ROCK) {
                        map.swapValues(Vec2(x, y), freeTile)
                        freeTile = Vec2(x, freeTile.y + verticalProgression.step)
                    } else if (map[x][y] == CUBE_ROCK) {
                        freeTile = Vec2(x, y + verticalProgression.step)
                    }
                }
            }
        } else {
            for (y in verticalProgression) {
                var freeTile = Vec2(horizontalProgression.first, y)
                for (x in horizontalProgression) {
                    if (map[x][y] == ROUNDED_ROCK) {
                        map.swapValues(Vec2(x, y), freeTile)
                        freeTile = Vec2(freeTile.x + horizontalProgression.step, y)
                    } else if (map[x][y] == CUBE_ROCK) {
                        freeTile = Vec2(x + horizontalProgression.step, y)
                    }
                }
            }
        }
    }
}