package commons

typealias IntArray2D = Array<IntArray>

fun String.to2DIntArray() = lines().map { it.map(Char::digitToInt).toIntArray() }.toTypedArray()
operator fun IntArray2D.get(pos: Vector2): Int = this[pos.x][pos.y]
operator fun IntArray2D.get(x: Int, y: Int): Int = this[x][y]
operator fun IntArray2D.contains(pos: Vector2): Boolean = getOrNull(pos.x)?.getOrNull(pos.y) != null
fun IntArray2D.getOrNull(pos: Vector2): Int? = getOrNull(pos.x)?.getOrNull(pos.y)
fun IntArray2D.locate(number: Int): Vector2? {
    for (x in indices) {
        for (y in get(x).indices) {
            if (get(x, y) == number) return Vector2(x, y)
        }
    }
    return null
}

operator fun IntArray2D.set(pos: Vector2, value: Int) {
    this[pos.x][pos.y] = value
}

fun IntArray2D.swapValues(pos1: Vector2, pos2: Vector2) {
    this[pos1].let { this[pos1] = this[pos2]; this[pos2] = it }
}

fun IntArray2D.deepCopy() = Array(size) { get(it).clone() }
