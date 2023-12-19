package commons

import kotlin.math.pow

fun Number.pow(power: Number) = toDouble().pow(power.toInt())

fun Double.ceil() = kotlin.math.ceil(this)
fun Float.ceil() = kotlin.math.ceil(this)

fun Double.floor() = kotlin.math.floor(this)
fun Float.floor() = kotlin.math.floor(this)