package com.matthias.aoc

import java.net.URI
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import kotlin.io.path.createParentDirectories
import kotlin.io.path.exists
import kotlin.io.path.readText

private const val AOC_BASE_URL = "https://adventofcode.com"
private const val SESSION_FILE_LOCATION = "session"
private const val STORAGE_LOCATION = "src/test/resources"

fun downloadAocInputFileIfMissing(year: Int, day: Int) {
    val destination = Path.of("$STORAGE_LOCATION/$year/$day/full")
    if (destination.exists()) return

    val sessionToken = try {
        Path.of(SESSION_FILE_LOCATION).readText().trim()
    } catch (ex: NoSuchFileException) {
        throw RuntimeException("Cannot download input because of missing 'session' file", ex)
    }

    println("Downloading aoc input file for: year $year, day $day")
    destination.createParentDirectories()
    URI("$AOC_BASE_URL/$year/day/$day/input").toURL().openConnection().apply {
        setRequestProperty("Cookie", "session=$sessionToken")
        inputStream.use { Files.write(destination, it.bufferedReader().readText().trimIndent().toByteArray()) }
    }
}

fun readAocInputFile(year: Int, day: Int, name: String) = Path.of("$STORAGE_LOCATION/$year/$day/$name")
                                                          ?: throw IllegalArgumentException("Input file not found")
