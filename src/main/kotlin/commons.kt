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

fun Long.pow(power: Int) = toDouble().pow(power.toDouble())
fun Int.pow(power: Int) = toDouble().pow(power.toDouble())

val IntRange.size
    get() = last - first + 1

val LongRange.size
    get() = last - first + 1

fun Double.floor() = floor(this)
fun Double.ceil() = ceil(this)

fun List<String>.contains(position: Pair<Int, Int>): Boolean = getOrNull(position.first)?.getOrNull(position.second)?.let { true } ?: false
fun List<String>.charAt(position: Pair<Int, Int>): Char = this[position.first][position.second]
fun List<String>.positionOf(searched: Char): Pair<Int, Int> {
    this.forEachIndexed { x, line ->
        line.forEachIndexed { y, char -> if (char == searched) return x to y }
    }
    error("Searched element '$searched' was not found")
}