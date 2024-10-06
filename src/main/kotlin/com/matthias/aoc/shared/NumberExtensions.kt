package com.matthias.aoc.shared

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

fun Number.pow(power: Number) = toDouble().pow(power.toInt())

fun Double.ceil() = ceil(this)
fun Float.ceil() = ceil(this)

fun Double.floor() = floor(this)
fun Float.floor() = floor(this)