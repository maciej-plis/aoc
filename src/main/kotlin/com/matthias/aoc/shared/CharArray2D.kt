package com.matthias.aoc.shared

typealias CharArray2D = Array<CharArray>

fun String.to2DCharArray() = lines().map { it.toCharArray() }.toTypedArray()
operator fun CharArray2D.get(pos: Vector2): Char = this[pos.x][pos.y]
operator fun CharArray2D.get(x: Int, y: Int): Char = this[x][y]
operator fun CharArray2D.contains(pos: Vector2): Boolean = getOrNull(pos.x)?.getOrNull(pos.y) != null
fun CharArray2D.getOrNull(pos: Vector2): Char? = getOrNull(pos.x)?.getOrNull(pos.y)
fun CharArray2D.locate(char: Char): Vector2? {
    for (x in indices) {
        for (y in get(x).indices) {
            if (get(x, y) == char) return Vector2(x, y)
        }
    }
    return null
}

operator fun CharArray2D.set(pos: Vector2, value: Char) {
    this[pos.x][pos.y] = value
}

fun CharArray2D.swapValues(pos1: Vector2, pos2: Vector2) {
    this[pos1].let { this[pos1] = this[pos2]; this[pos2] = it }
}

fun CharArray2D.join2DArrayToString(itemSeparator: String = "", lineSeparator: String = "\n") =
    joinToString(lineSeparator) { it.joinToString(itemSeparator) }

fun CharArray2D.deepCopy() = Array(size) { get(it).clone() }
