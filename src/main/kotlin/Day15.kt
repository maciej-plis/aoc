import Instruction.AddOrReplaceInstruction
import Instruction.DeleteInstruction

private val INSTRUCTION_REGEX = """(?<label>[a-z]+)[-=](?<lens>\d+)?""".toRegex()

private sealed interface Instruction {
    val label: String

    data class DeleteInstruction(override val label: String) : Instruction
    data class AddOrReplaceInstruction(override val label: String, val lens: Int) : Instruction
}

internal class Day15 {

    fun solvePart1(input: String): Int {
        return input.splitToSequence(",")
            .map { it.runHashAlgorithm() }
            .sum()
    }

    fun solvePart2(input: String): Int {
        val lensConfiguration = hashMapOf<Int, LinkedHashMap<String, Int>>()

        input.splitToSequence(",")
            .map { parseInstruction(it) }
            .forEach { lensConfiguration.applyInstruction(it) }

        return lensConfiguration.entries.sumOf { (label, box) ->
            box.values.foldIndexed(0) { lensIndex, sum, lens -> (sum + (label + 1) * (lensIndex + 1) * lens) } as Int
        }
    }

    private fun String.runHashAlgorithm() = fold(0) { acc, c -> ((acc + c.code) * 17) % 256 }

    private fun HashMap<Int, LinkedHashMap<String, Int>>.applyInstruction(instruction: Instruction) {
        val boxLabel = instruction.label.runHashAlgorithm()
        when (instruction) {
            is DeleteInstruction -> this.computeIfPresent(boxLabel) { _, box -> box.remove(instruction.label); box }
            is AddOrReplaceInstruction -> this.getOrPut(boxLabel) { LinkedHashMap() }.put(instruction.label, instruction.lens)
        }
    }

    private fun parseInstruction(text: String): Instruction {
        val match = INSTRUCTION_REGEX.matchEntire(text)
        val label = match?.groups?.get("label")?.value ?: error("Instruction label is missing")
        val lens = match?.groups?.get("lens")?.value?.toInt()
        return if (lens == null) DeleteInstruction(label) else AddOrReplaceInstruction(label, lens)
    }
}