package com.matthias.aoc.y2015

private val LINE_PATTERN = """(\w+) to (\w+) = (\d+)""".toRegex()

internal class Day9 {

    fun solvePart1(input: String): Int {
        val cities = parseCities(input)
        return cities
            .map { findShortestPath(it, cities.size) }
            .filterNotNull()
            .min()
    }

    private fun findShortestPath(currentCity: City, citiesToVisit: Int, alreadyVisited: Set<City> = setOf()): Int? {
        if (citiesToVisit == alreadyVisited.size + 1) return 0
        return currentCity.connections
            .filterKeys { it !in alreadyVisited }
            .map { findShortestPath(it.key, citiesToVisit, alreadyVisited + currentCity)?.plus(it.value) }
            .filterNotNull()
            .minOrNull()
    }

    fun solvePart2(input: String): Int {
        val cities = parseCities(input)
        return cities
            .map { findLongestPath(it, cities.size) }
            .filterNotNull()
            .max()
    }

    private fun findLongestPath(currentCity: City, citiesToVisit: Int, alreadyVisited: Set<City> = setOf()): Int? {
        if (citiesToVisit == alreadyVisited.size + 1) return 0
        return currentCity.connections
            .filterKeys { it !in alreadyVisited }
            .map { findLongestPath(it.key, citiesToVisit, alreadyVisited + currentCity)?.plus(it.value) }
            .filterNotNull()
            .maxOrNull()
    }

    private data class City(val name: String) {
        val connections: MutableMap<City, Int> = mutableMapOf()
        override fun toString() = "[${connections.map { "${it.key.name} - ${it.value}" }.joinToString(", ")}]"
    }

    private fun parseCities(input: String): Set<City> {
        val cities = hashMapOf<String, City>()
        input.lineSequence().forEach {
            val (_, from, to, distance) = LINE_PATTERN.matchEntire(it)!!.groupValues
            val fromCity = cities.getOrPut(from) { City(from) }
            val toCity = cities.getOrPut(to) { City(to) }
            fromCity.connections[toCity] = distance.toInt()
            toCity.connections[fromCity] = distance.toInt()
        }
        return cities.values.toSet()
    }
}