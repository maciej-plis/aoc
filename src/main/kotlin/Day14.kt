import commons.*
import commons.Direction.*

private const val ROUNDED_ROCK = 'O'
private const val CUBE_ROCK = '#'
private const val EMPTY_SPACE = '.'

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
        val mapCycles = mutableListOf(map.join2DArrayToString())
        val cycles = 1_000_000_000

        for (i in 1..cycles) {
            tiltMap(map, NORTH)
            tiltMap(map, WEST)
            tiltMap(map, SOUTH)
            tiltMap(map, EAST)

            val mapString = map.join2DArrayToString()
            if (mapCycles.contains(mapString)) break
            mapCycles += mapString
        }

        val startAt = mapCycles.indexOf(map.join2DArrayToString())
        val endAt = mapCycles.lastIndex
        val size = endAt - startAt + 1
        val resultIndex = (cycles - startAt + size) % size + startAt

        return mapCycles[resultIndex].lines().reversed()
            .mapIndexed { index, line -> (index + 1) * line.count { it == ROUNDED_ROCK } }
            .sum()
    }

    private fun tiltMap(map: Array<CharArray>, direction: Direction) = when (direction) {
        NORTH, SOUTH -> tiltMapNorthSouth(map, direction)
        EAST, WEST -> tiltMapEastWest(map, direction)
    }

    private fun tiltMapNorthSouth(map: Array<CharArray>, direction: Direction) {
        val horizontalProgression = map.indices.let { if (direction == SOUTH) it.reversed() else it }
        val verticalProgression = map.first().indices

        for (y in verticalProgression) {
            var freeTile = Vector2(horizontalProgression.first, y)
            for (x in horizontalProgression) {
                if (map[x][y] == ROUNDED_ROCK) {
                    map.swapValues(Vector2(x, y), freeTile)
                    freeTile = Vector2(freeTile.x + horizontalProgression.step, y)
                } else if (map[x][y] == CUBE_ROCK) {
                    freeTile = Vector2(x + horizontalProgression.step, y)
                }
            }
        }
    }

    private fun tiltMapEastWest(map: Array<CharArray>, direction: Direction) {
        val horizontalProgression = map.indices
        val verticalProgression = map.first().indices.let { if (direction == EAST) it.reversed() else it }

        for (x in horizontalProgression) {
            var freeTile = Vector2(x, verticalProgression.first)
            for (y in verticalProgression) {
                if (map[x][y] == ROUNDED_ROCK) {
                    map.swapValues(Vector2(x, y), freeTile)
                    freeTile = Vector2(x, freeTile.y + verticalProgression.step)
                } else if (map[x][y] == CUBE_ROCK) {
                    freeTile = Vector2(x, y + verticalProgression.step)
                }
            }
        }
    }
}