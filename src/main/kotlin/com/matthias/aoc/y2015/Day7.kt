package com.matthias.aoc.y2015

private val TRANSFORM_INSTRUCTION_REGEX = """([a-z]+|[0-9]+) -> ([a-z]+)""".toRegex()
private val AND_INSTRUCTION_REGEX = """([a-z]+|[0-9]+) AND ([a-z]+|[0-9]+) -> ([a-z]+)""".toRegex()
private val OR_INSTRUCTION_REGEX = """([a-z]+|[0-9]+) OR ([a-z]+|[0-9]+) -> ([a-z]+)""".toRegex()
private val LEFT_SHIFT_INSTRUCTION_REGEX = """([a-z]+|[0-9]+) LSHIFT (\d+) -> ([a-z]+)""".toRegex()
private val RIGHT_SHIFT_INSTRUCTION_REGEX = """([a-z]+|[0-9]+) RSHIFT (\d+) -> ([a-z]+)""".toRegex()
private val NOT_INSTRUCTION_REGEX = """NOT ([a-z]+|[0-9]+) -> ([a-z]+)""".toRegex()

internal class Day7 {

    fun solvePart1(input: String): Int {
        val searchedOutput = "a"

        val instructions = input.lines()
            .map(this::toInstruction)
            .groupBy { it.identifier }
            .mapValues { it.value.first() }

        return instructions
            .getValue(searchedOutput)
            .computeValue(instructions).toInt()
    }

    fun solvePart2(input: String): Int {
        val regexToReplace = """\d+(?= -> b\n)""".toRegex()
        val part1Solution = solvePart1(input)

        val modifiedInput = input.replace(regexToReplace, part1Solution.toString())
        return solvePart1(modifiedInput)
    }

    // @formatter:off
    private fun toInstruction(input: String) =
        TRANSFORM_INSTRUCTION_REGEX.matchEntire(input)?.groupValues?.let { Instruction(it[2]) { instructions -> toInstructionValue(it[1], instructions) } } ?:
        AND_INSTRUCTION_REGEX.matchEntire(input)?.groupValues?.let { Instruction(it[3]) { instructions -> toInstructionValue(it[1], instructions) and toInstructionValue(it[2], instructions)  } } ?:
        OR_INSTRUCTION_REGEX.matchEntire(input)?.groupValues?.let { Instruction(it[3]) { instructions -> toInstructionValue(it[1], instructions) or toInstructionValue(it[2], instructions)  } } ?:
        LEFT_SHIFT_INSTRUCTION_REGEX.matchEntire(input)?.groupValues?.let { Instruction(it[3]) { instructions -> (toInstructionValue(it[1], instructions).toInt() shl it[2].toInt()).toUShort() } } ?:
        RIGHT_SHIFT_INSTRUCTION_REGEX.matchEntire(input)?.groupValues?.let { Instruction(it[3]) { instructions -> (toInstructionValue(it[1], instructions).toInt() shr it[2].toInt()).toUShort() } } ?:
        NOT_INSTRUCTION_REGEX.matchEntire(input)?.groupValues?.let { Instruction(it[2]) { instructions -> toInstructionValue(it[1], instructions).inv() } } ?:
        throw java.lang.IllegalStateException()
    // @formatter:on

    private fun toInstructionValue(input: String, instructions: Map<String, Instruction>) = input.toUShortOrNull() ?: instructions.getValue(input).computeValue(instructions)

    private data class Instruction(
        val identifier: String,
        val transformFunction: (instructions: Map<String, Instruction>) -> UShort
    ) {
        private var value: UShort? = null
        fun computeValue(instructions: Map<String, Instruction>) = value ?: transformFunction(instructions).apply { value = this }
    }
}