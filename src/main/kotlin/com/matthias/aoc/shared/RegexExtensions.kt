package com.matthias.aoc.shared

fun Regex.findValue(text: String, group: String) = find(text)?.groups?.get(group)?.value
fun Regex.findValues(text: String, groups: Set<String>) = findAll(text).map { match -> groups.associateWith { match.groups.get(it)?.value } }.toList()
