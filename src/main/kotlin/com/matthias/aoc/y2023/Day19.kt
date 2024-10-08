package com.matthias.aoc.y2023

import com.matthias.aoc.shared.*

private val PART_RATING_REGEX = """(?<ratingCode>[a-z])=(?<rating>\d+)""".toRegex()
private val WORKFLOW_NAME_REGEX = """^(?<workflowName>[a-z]+)\{.*}$""".toRegex()
private val WORKFLOW_STEP_REGEX = """(?<ratingCode>[xmas])(?<criteria>[<>])(?<criteriaValue>\d+):(?<nextWorkflow>[a-zA-Z]+)""".toRegex()
private val DEFAULT_WORKFLOW_REGEX = """^[a-z]+\{.*,(?<defaultWorkflow>[a-zA-Z]+)}$""".toRegex()

internal class Day19 {

    private data class Part(val ratings: Map<String, Int>) {
        val ratingSum: Int = ratings.values.sum()
        fun getRatingValue(ratingCode: String) = ratings.getValue(ratingCode)
    }

    private data class Workflow(val steps: List<WorkflowStep>, val defaultNextWorkflow: String) {
        fun evaluateNextWorkflow(part: Part) = steps.firstOrNull { it.criteria.matches(part.getRatingValue(it.ratingCode)) }?.nextWorkflow ?: defaultNextWorkflow
    }

    private data class WorkflowStep(val ratingCode: String, val criteria: WorkflowCriteria, val nextWorkflow: String)
    private data class WorkflowCriteria(val criteria: String, val criteriaValue: Int) {
        fun matches(rating: Int) = when (criteria) {
            ">" -> rating > criteriaValue
            "<" -> rating < criteriaValue
            else -> error("Invalid criteria")
        }
    }

    fun solvePart1(input: String): Int {
        val (workflowsInput, partsInput) = input.splitByDoubleNewLine()
        val workflows = parseWorkflows(workflowsInput)

        return partsInput.lineSequence()
            .map { parsePart(it) }
            .filter { evaluatePart(it, workflows) }
            .sumOf { it.ratingSum }
    }

    fun solvePart2(input: String): Long {
        val (workflowsInput, _) = input.splitByDoubleNewLine()
        val workflows = parseWorkflows(workflowsInput)

        val ratingRange = 1..4000
        val probe = mutableMapOf("x" to ratingRange, "m" to ratingRange, "a" to ratingRange, "s" to ratingRange)

        return countPassingCombinationsForWorkflow(workflows, workflows["in"]!!, probe)
    }

    private fun countPassingCombinationsForWorkflow(workflows: Map<String, Workflow>, workflow: Workflow, probe: MutableMap<String, IntRange>): Long {
        var sum = 0L
        workflow.steps.forEach {
            val crt = it.criteria

            when (crt.criteria) {
                ">" -> {
                    val temp = probe.toMutableMap().apply { computeIfPresent(it.ratingCode) { _, ratingRange -> crt.criteriaValue + 1..ratingRange.last } }
                    if (it.nextWorkflow == "A") sum += temp.values.productOf { it.size.toLong() }
                    else if (it.nextWorkflow != "R") sum += countPassingCombinationsForWorkflow(workflows, workflows[it.nextWorkflow]!!, temp)
                    probe.computeIfPresent(it.ratingCode) { _, ratingRange -> ratingRange.first..crt.criteriaValue }
                }

                "<" -> {
                    val temp = probe.toMutableMap().apply { computeIfPresent(it.ratingCode) { _, ratingRange -> ratingRange.first..<crt.criteriaValue } }
                    if (it.nextWorkflow == "A") sum += temp.values.productOf { it.size.toLong() }
                    else if (it.nextWorkflow != "R") sum += countPassingCombinationsForWorkflow(workflows, workflows[it.nextWorkflow]!!, temp)
                    probe.computeIfPresent(it.ratingCode) { _, ratingRange -> crt.criteriaValue..ratingRange.last }
                }

                else -> error("")
            }
        }

        if (workflow.defaultNextWorkflow == "A") return sum + probe.values.productOf { it.size.toLong() }
        else if (workflow.defaultNextWorkflow == "R") return sum
        return sum + countPassingCombinationsForWorkflow(workflows, workflows[workflow.defaultNextWorkflow]!!, probe.toMutableMap())
    }

    private fun <T> Iterable<T>.productOf(selector: (T) -> Long): Long = map(selector).product()

    private fun evaluatePart(part: Part, workflows: Map<String, Workflow>): Boolean {
        var workflowName = "in"
        while (workflowName != "A" && workflowName != "R") {
            val workflow = workflows.getValue(workflowName)
            workflowName = workflow.evaluateNextWorkflow(part)
        }
        return if (workflowName == "A") true else false
    }

    private fun parseWorkflows(workflowsInput: String) = workflowsInput.lineSequence()
        .associate { parseWorkflow(it) }

    private fun parseWorkflow(workflowLine: String): Pair<String, Workflow> {
        val name = WORKFLOW_NAME_REGEX.findValue(workflowLine, "workflowName")!!
        val defaultWorkflow = DEFAULT_WORKFLOW_REGEX.findValue(workflowLine, "defaultWorkflow")!!
        val steps = WORKFLOW_STEP_REGEX.findValues(workflowLine, setOf("ratingCode", "criteria", "criteriaValue", "nextWorkflow"))
            .map { WorkflowStep(it["ratingCode"]!!, WorkflowCriteria(it["criteria"]!!, it["criteriaValue"]!!.toInt()), it["nextWorkflow"]!!) }

        return name to Workflow(steps, defaultWorkflow)
    }

    private fun parsePart(partInput: String) = PART_RATING_REGEX.findValues(partInput, setOf("ratingCode", "rating"))
        .associate { it["ratingCode"]!! to it["rating"]!!.toInt() }
        .let { Part(it) }
}