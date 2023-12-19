package commons

fun String.to2DCharArray() = lines().map { it.toCharArray() }.toTypedArray()
operator fun Array<CharArray>.get(pos: Vector2): Char = this[pos.x][pos.y]
operator fun Array<CharArray>.contains(pos: Vector2): Boolean = getOrNull(pos.x)?.getOrNull(pos.y) != null
fun Array<CharArray>.getOrNull(pos: Vector2): Char? = getOrNull(pos.x)?.getOrNull(pos.y)

operator fun Array<CharArray>.set(pos: Vector2, value: Char) {
    this[pos.x][pos.y] = value
}

fun Array<CharArray>.swapValues(pos1: Vector2, pos2: Vector2) {
    this[pos1].let { this[pos1] = this[pos2]; this[pos2] = it }
}

fun Array<CharArray>.join2DArrayToString(itemSeparator: String = "", lineSeparator: String = "\n") =
    joinToString(lineSeparator) { it.joinToString(itemSeparator) }
