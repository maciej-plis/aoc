internal class Day9 {

    val findNextElementOfSequence = DeepRecursiveFunction { sequence: List<Long> ->
        val subSequence = sequence.zipWithNext { a, b -> (b - a) }
        return@DeepRecursiveFunction sequence.last() + (subSequence.distinct().singleOrNull() ?: callRecursive(subSequence))
    }

    fun solvePart1(input: String): Long {
        return input.lineSequence()
            .map { it.splitByWs().map(String::toLong) }
            .map { findNextElementOfSequence(it) }
            .sum()
    }

    fun solvePart2(input: String): Long {
        return input.lineSequence()
            .map { it.splitByWs().map(String::toLong) }
            .map { findNextElementOfSequence(it.reversed()) }
            .sum()
    }
}