package com.matthias.aoc.shared

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

fun Number.pow(power: Number) = toDouble().pow(power.toInt())

val Int.even; get() = this % 2 == 0
val Long.even; get() = this % 2 == 0L

val Int.odd; get() = this % 2 == 1
val Long.odd; get() = this % 2 == 1L

fun Double.ceil() = ceil(this)
fun Float.ceil() = ceil(this)

fun Double.floor() = floor(this)
fun Float.floor() = floor(this)