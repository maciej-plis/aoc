package commons

fun String.to2DIntArray() = lines().map { it.map(Char::digitToInt).toIntArray() }.toTypedArray()
operator fun Array<IntArray>.get(pos: Vector2): Int = this[pos.x][pos.y]
operator fun Array<IntArray>.contains(pos: Vector2): Boolean = getOrNull(pos.x)?.getOrNull(pos.y) != null
fun Array<IntArray>.getOrNull(pos: Vector2): Int? = getOrNull(pos.x)?.getOrNull(pos.y)

operator fun Array<IntArray>.set(pos: Vector2, value: Int) {
    this[pos.x][pos.y] = value
}

fun Array<IntArray>.swapValues(pos1: Vector2, pos2: Vector2) {
    this[pos1].let { this[pos1] = this[pos2]; this[pos2] = it }
}