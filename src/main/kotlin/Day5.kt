import kotlin.math.max
import kotlin.math.min

internal class Day5 {

    data class Mapping(val sourceRange: LongRange, val change: Long)

    fun solvePart1(input: String): Long {
        val (seedsInput, mappingsInput) = input.split("\n\n", limit = 2)

        val seeds = seedsInput.drop("seeds: ".length).split("\\s+".toRegex()).map { it.toLong() }
        val mappingGroups = mappingsInput.split("\n\n").map {
            it.lines().drop(1).map {
                val (dest, source, range) = it.split("\\s+".toRegex()).map { it.toLong() }
                Mapping(source..<source + range, dest - source)
            }
        }

        val results = seeds.map {
            var seed = it
            mappingGroups.forEach { mappingGroup ->
                seed += (mappingGroup.firstOrNull { seed in it.sourceRange }?.change ?: 0)
            }
            return@map seed
        }

        return results.min()
    }

    fun solvePart2(input: String): Long {
        val (seedsInput, mappingsInput) = input.split("\n\n", limit = 2)

        val seedRanges = seedsInput.drop("seeds: ".length)
            .split("\\s+".toRegex()).map { it.toLong() }
            .chunked(2)
            .map { (start, range) -> start..<start + range }

        val mappingGroups = mappingsInput.split("\n\n").map {
            it.lines().drop(1).map {
                val (dest, source, range) = it.split("\\s+".toRegex()).map { it.toLong() }
                Mapping(source..<source + range, dest - source)
            }
        }

        val results = seedRanges.flatMap {
            var ranges = mutableListOf(it)
            var mapped = mutableListOf<LongRange>()
            mappingGroups.forEachIndexed { index, mappingGroup ->
                mappingGroup.forEach { mapping ->
                    var i = 0
                    while (i in ranges.indices) {
                        val range = ranges[i]
                        val (left, inner, right) = mapping.sourceRange.join(range)
                        if (inner != null) {
                            if (left != null) ranges.add(left)
                            if (right != null) ranges.add(right)
                            mapped.add(inner.first + mapping.change..inner.last + mapping.change)
                            ranges.removeAt(i)
                            continue
                        }
                        i++
                    }
                }
                ranges += mapped
                mapped.clear()
            }
            return@flatMap ranges
        }

        return results.minOf { it.first }
    }

    fun LongRange.join(range: LongRange): Triple<LongRange?, LongRange?, LongRange?> {
        if (range.last < this.first) return Triple(range, null, null)
        if (range.first > this.last) return Triple(null, null, range)

        val leftOuter = if (range.first < this.first) range.first..this.first - 1 else null
        val rightOuter = if (range.last > this.last) this.last + 1..range.last else null
        val inner = max(range.first, this.first)..min(range.last, this.last)
        return Triple(leftOuter, inner, rightOuter)
    }
}