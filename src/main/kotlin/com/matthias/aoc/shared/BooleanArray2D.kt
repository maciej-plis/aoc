package com.matthias.aoc.shared

typealias BooleanArray2D = Array<BooleanArray>

fun BooleanArray2D(width: Int, height: Int): BooleanArray2D = Array(height) { BooleanArray(width) }

operator fun BooleanArray2D.get(pos: Vector2): Boolean = this[pos.x][pos.y]
operator fun BooleanArray2D.get(x: Int, y: Int): Boolean = this[x][y]
operator fun BooleanArray2D.set(pos: Vector2, value: Boolean) {
    this[pos.x][pos.y] = value
}