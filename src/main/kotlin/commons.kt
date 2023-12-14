import kotlin.io.path.toPath
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

fun readResourceFile(path: String) =
    object {}.javaClass.classLoader.getResource(path)?.toURI()?.toPath() ?: throw IllegalArgumentException("Resource file not found: $path")

fun String.find(regex: Regex, startIndex: Int = 0) = regex.find(this, startIndex)

fun String.findAll(regex: Regex, startIndex: Int = 0) = regex.findAll(this, startIndex)

fun Iterable<Int>.product() = reduce(Int::times)
fun Iterable<Long>.product() = reduce(Long::times)

fun String.splitByWs() = split("\\s+".toRegex())

fun Iterable<String>.toInt() = map(String::toInt)
fun Iterable<String>.toLong() = map(String::toLong)

fun Number.pow(power: Number) = toDouble().pow(power.toDouble())

val IntRange.size; get() = last - first + 1
val LongRange.size; get() = last - first + 1
val ClosedRange<Double>.size; get() = endInclusive - start + 1
val ClosedRange<Float>.size; get() = endInclusive - start + 1

fun Double.floor() = floor(this)
fun Double.ceil() = ceil(this)

data class Vec2(val x: Int, val y: Int) {
    override fun toString() = "($x, $y)"
}

fun String.to2DCharArray() = lines().map { it.toCharArray() }.toTypedArray()
operator fun Array<CharArray>.get(pos: Vec2): Char = this[pos.x][pos.y]
operator fun Array<CharArray>.set(pos: Vec2, value: Char) {
    this[pos.x][pos.y] = value
}

fun Array<CharArray>.swapValues(pos1: Vec2, pos2: Vec2) {
    this[pos1].let { this[pos1] = this[pos2]; this[pos2] = it }
}

fun Array<CharArray>.join2DArrayToString(lineSeparator: String = "\n", itemSeparator: String = "") =
    map { it.joinToString(itemSeparator) }.joinToString(lineSeparator)

fun List<String>.contains(position: Pair<Int, Int>): Boolean = getOrNull(position.first)?.getOrNull(position.second)?.let { true } ?: false
fun List<String>.charAt(position: Pair<Int, Int>): Char = this[position.first][position.second]
fun List<String>.replace(position: Pair<Int, Int>, replacement: Char) = mapIndexed { index, line ->
    if (position.first == index) StringBuilder(line).apply { setCharAt(position.second, replacement) }.toString() else line
}

fun List<String>.positionOf(searched: Char): Pair<Int, Int> {
    this.forEachIndexed { x, line ->
        line.forEachIndexed { y, char -> if (char == searched) return x to y }
    }
    error("Searched element '$searched' was not found")
}

fun Regex.findValue(text: String, group: String) = find(text)?.groups?.get(group)?.value
fun Regex.findValues(text: String, groups: Set<String>) = findAll(text).map { match -> groups.associateWith { match.groups.get(it)?.value } }.toList()