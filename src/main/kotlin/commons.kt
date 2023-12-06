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

fun Int.pow(power: Int) = toDouble().pow(power.toDouble())

val IntRange.size
    get() = last - first + 1

val LongRange.size
    get() = last - first + 1

fun Double.floor() = floor(this)
fun Double.ceil() = ceil(this)
