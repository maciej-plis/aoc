package commons

val IntRange.size; get() = last - first + 1
val LongRange.size; get() = last - first + 1
val ClosedRange<Double>.size; get() = endInclusive - start + 1
val ClosedRange<Float>.size; get() = endInclusive - start + 1