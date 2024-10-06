package com.matthias.aoc.y2023

import com.matthias.aoc.shared.splitByWs
import kotlin.invoke

internal class Day12 {

    data class RecordEntry(val springsRecord: String, val brokenGroups: List<Int>)

    val computedCombinations = HashMap<RecordEntry, Long>()

    val countPossibleCombinations = DeepRecursiveFunction<RecordEntry, Long> { recordEntry: RecordEntry ->
        if (computedCombinations.contains(recordEntry)) return@DeepRecursiveFunction computedCombinations.getValue(recordEntry)
        val (isPossible, reducedRecord) = isRecordPossible(recordEntry)
        if (!isPossible) return@DeepRecursiveFunction 0
        if (reducedRecord == null) return@DeepRecursiveFunction 1
        return@DeepRecursiveFunction (callRecursive(RecordEntry(reducedRecord!!.springsRecord.replaceFirst('?', '#'), reducedRecord.brokenGroups)) +
            callRecursive(
                RecordEntry(
                    reducedRecord.springsRecord.replaceFirst('?', '.'),
                    reducedRecord.brokenGroups
                )
            )).also { computedCombinations[reducedRecord] = it }
    }

    fun solvePart1(input: String): Long {
        return input.lineSequence()
            .map { it.splitByWs() }
            .map { (springsRecord, brokenGroups) -> RecordEntry(springsRecord, brokenGroups.split(",").mapToInt()) }
            .sumOf { countPossibleCombinations(it) }
    }

    fun solvePart2(input: String): Long {
        val folds = 5
        return input.lineSequence()
            .map { it.splitByWs() }
            .map { (springsRecord, brokenGroups) -> springsRecord to brokenGroups.split(",").mapToInt() }
            .map { (springsRecord, brokenGroups) -> listOf(springsRecord).repeat(folds).joinToString("?") to brokenGroups.times(folds) }
            .map { (springsRecord, brokenGroups) -> RecordEntry(springsRecord, brokenGroups) }
            .sumOf { countPossibleCombinations(it) }
    }

    fun isRecordPossible(recordEntry: RecordEntry): Pair<Boolean, RecordEntry?> {
        var checkedUpTo = 0
        var group = 0
        var groupSize = 0
        for (i in recordEntry.springsRecord.indices) {
            if (recordEntry.springsRecord[i] == '?') return true to RecordEntry(
                recordEntry.springsRecord.substring(checkedUpTo),
                recordEntry.brokenGroups.drop(group)
            )
            if (recordEntry.springsRecord[i] == '#') groupSize++
            if (recordEntry.springsRecord[i] == '.' && groupSize > 0) {
                if (recordEntry.brokenGroups.getOrNull(group) != groupSize) return false to null
                checkedUpTo = i + 1
                group++
                groupSize = 0
            }
        }

        if (groupSize > 0) {
            if (recordEntry.brokenGroups.getOrNull(group) != groupSize) return false to null
            group++
        }

        if (group < recordEntry.brokenGroups.size) return false to null

        return true to null
    }
}

fun Iterable<String>.mapToInt() = map { it.toInt() }
fun <T> Iterable<T>.repeat(times: Int) = flatMap { value -> (0..<times).map { value } }
fun <T> Iterable<T>.times(count: Int) = (1..count).flatMap { this }