package commons

fun gcd(numbers: Collection<Long>) = numbers.reduce { acc, number -> gcd(acc, number) }
fun gcd(number1: Long, number2: Long): Long {
    var a = number1
    var b = number2
    while (b != 0L) {
        val t = b
        b = a % b
        a = t
    }
    return a
}

fun lcm(numbers: Collection<Long>) = numbers.product() / gcd(numbers)
fun lcm(number1: Long, number2: Long): Long {
    return (number1 * number2) / gcd(number1, number2)
}