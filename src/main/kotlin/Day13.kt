import Day13.Reflection.Type.HORIZONTAL
import Day13.Reflection.Type.VERTICAL
import commons.charAt
import commons.replace
import commons.size
import kotlin.math.min

internal class Day13 {

    private data class Reflection(val type: Type, val range: IntRange) {
        val leftOrAboveCools: Int; get() = (range.size / 2) + range.first

        enum class Type {
            VERTICAL, HORIZONTAL
        }
    }

    fun solvePart1(input: String): Int {
        return input.splitToSequence("\n\n")
            .map { it.lines() }
            .map { findReflection(it)!! }
            .map { computeResult(it) }
            .sum()
    }

    fun solvePart2(input: String): Int {
        return input.splitToSequence("\n\n")
            .map { it.lines() }
            .map { it to findReflection(it)!! }
            .map { (pattern, reflection) -> findSmudgedReflection(pattern, reflection)!! }
            .map { computeResult(it) }
            .sum()
    }

    private fun findReflection(pattern: List<String>): Reflection? {
        findHorizontalReflectionRange(pattern)?.let { return Reflection(HORIZONTAL, it) }
        findVerticalReflectionRange(pattern.rotate())?.let { return Reflection(VERTICAL, it) }
        return null
    }

    private fun findSmudgedReflection(pattern: List<String>, baseReflection: Reflection): Reflection? {
        for (x in pattern.indices) {
            for (y in pattern.first().indices) {
                val smudge = pattern.charAt(x to y)
                val fixedPattern = pattern.replace(x to y, if (smudge == '.') '#' else '.')
                findHorizontalReflectionRange(fixedPattern, ignored = setOf(baseReflection))?.let { return Reflection(HORIZONTAL, it) }
                findVerticalReflectionRange(fixedPattern.rotate(), ignored = setOf(baseReflection))?.let { return Reflection(VERTICAL, it) }
            }
        }
        return null
    }

    private fun findHorizontalReflectionRange(pattern: List<String>, ignored: Set<Reflection> = emptySet()): IntRange? {
        for (i in pattern.indices) {
            if (pattern[i] == pattern.getOrNull(i + 1)) {
                val rangeSize = min(i, pattern.lastIndex - (i + 1))
                val range = (i - rangeSize)..((i + 1) + rangeSize)
                if (Reflection(HORIZONTAL, range) !in ignored && hasFullReflection(pattern, range)) {
                    return range
                }
            }
        }
        return null
    }

    private fun findVerticalReflectionRange(pattern: List<String>, ignored: Set<Reflection> = emptySet()): IntRange? {
        for (i in pattern.indices) {
            if (pattern[i] == pattern.getOrNull(i + 1)) {
                val rangeSize = min(i, pattern.lastIndex - (i + 1))
                val range = (i - rangeSize)..((i + 1) + rangeSize)
                if (Reflection(VERTICAL, range) !in ignored && hasFullReflection(pattern, range)) {
                    return range
                }
            }
        }
        return null
    }

    private fun hasFullReflection(pattern: List<String>, range: IntRange): Boolean {
        if (range.size % 2 != 0) error("Range should be even")
        for (i in 0..(range.size / 2)) {
            if (pattern[range.first + i] != pattern[range.last - i]) return false
        }
        return true
    }

    private fun computeResult(reflection: Reflection) = when (reflection.type) {
        VERTICAL -> reflection.leftOrAboveCools
        HORIZONTAL -> reflection.leftOrAboveCools * 100
    }
}