package com.matthias.aoc.y2023

import com.matthias.aoc.shared.*
import com.matthias.aoc.shared.Direction
import com.matthias.aoc.shared.Direction.*
import com.matthias.aoc.shared.Vector2
import com.matthias.aoc.shared.arrayDequeOf
import com.matthias.aoc.shared.contains
import com.matthias.aoc.shared.countDistinctOf
import com.matthias.aoc.shared.hashSetOf
import com.matthias.aoc.shared.to2DCharArray
import com.matthias.aoc.y2023.Mirror.*
import kotlin.collections.plusAssign

private data class LightBeam(val tile: Vector2, val direction: Direction) {
    fun north() = LightBeam(tile.north(), NORTH)
    fun east() = LightBeam(tile.east(), EAST)
    fun south() = LightBeam(tile.south(), SOUTH)
    fun west() = LightBeam(tile.west(), WEST)
}

private sealed interface Mirror {

    fun redirect(lightBeam: LightBeam): Set<LightBeam>

    data object HorizontalMirror : Mirror {
        override fun redirect(lightBeam: LightBeam) = when (lightBeam.direction) {
            NORTH, SOUTH -> setOf(lightBeam.east(), lightBeam.west())
            EAST -> setOf(lightBeam.east())
            WEST -> setOf(lightBeam.west())
        }
    }

    data object VerticalMirror : Mirror {
        override fun redirect(lightBeam: LightBeam) = when (lightBeam.direction) {
            EAST, WEST -> setOf(lightBeam.north(), lightBeam.south())
            NORTH -> setOf(lightBeam.north())
            SOUTH -> setOf(lightBeam.south())
        }
    }

    data object RightAngleMirror : Mirror {
        override fun redirect(lightBeam: LightBeam) = when (lightBeam.direction) {
            NORTH -> setOf(lightBeam.east())
            EAST -> setOf(lightBeam.north())
            SOUTH -> setOf(lightBeam.west())
            WEST -> setOf(lightBeam.south())
        }
    }

    data object LeftAngleMirror : Mirror {
        override fun redirect(lightBeam: LightBeam) = when (lightBeam.direction) {
            NORTH -> setOf(lightBeam.west())
            EAST -> setOf(lightBeam.south())
            SOUTH -> setOf(lightBeam.east())
            WEST -> setOf(lightBeam.north())
        }
    }

    data object BlankMirror : Mirror {
        override fun redirect(lightBeam: LightBeam) = when (lightBeam.direction) {
            NORTH -> setOf(lightBeam.north())
            EAST -> setOf(lightBeam.east())
            SOUTH -> setOf(lightBeam.south())
            WEST -> setOf(lightBeam.west())
        }
    }
}

internal class Day16 {

    fun solvePart1(input: String) = solve(input.to2DCharArray(), LightBeam(Vector2(0, 0), EAST))

    fun solvePart2(input: String): Int {
        val mirrorMap = input.to2DCharArray()

        val vertical = mirrorMap.indices
        val horizontal = mirrorMap.first().indices

        val leftSide = vertical.map { x -> LightBeam(Vector2(x, horizontal.first), EAST) }
        val rightSide = vertical.map { x -> LightBeam(Vector2(x, horizontal.last), WEST) }
        val topSide = horizontal.map { y -> LightBeam(Vector2(vertical.first, y), SOUTH) }
        val bottomSide = horizontal.map { y -> LightBeam(Vector2(vertical.last, y), NORTH) }

        return hashSetOf(leftSide, rightSide, topSide, bottomSide).maxOf { solve(mirrorMap, it) }
    }

    private fun solve(mirrorMap: Array<CharArray>, initialLightBeam: LightBeam): Int {
        val lightBeams = hashSetOf(initialLightBeam)
        val travelingLightBeams = arrayDequeOf(initialLightBeam)

        while (travelingLightBeams.isNotEmpty()) {
            val lightBeam = travelingLightBeams.removeFirst()
            val mirror = mirrorMap.getMirrorAt(lightBeam.tile)

            val redirectedLightBeams = mirror.redirect(lightBeam)
            redirectedLightBeams.forEach {
                if (it.tile in mirrorMap && !lightBeams.contains(it)) {
                    lightBeams += it
                    travelingLightBeams += it
                }
            }
        }

        return lightBeams.countDistinctOf { it.tile }
    }

    private fun Array<CharArray>.getMirrorAt(tile: Vector2) = when (this[tile]) {
        '|' -> VerticalMirror
        '-' -> HorizontalMirror
        '/' -> RightAngleMirror
        '\\' -> LeftAngleMirror
        '.' -> BlankMirror
        else -> error("Invalid mirror type")
    }
}
