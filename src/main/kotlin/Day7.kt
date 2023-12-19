import Day7.Hand.Type
import Day7.Hand.Type.*
import Day7.RuleSet.Part1RuleSet
import Day7.RuleSet.Part2RuleSet
import commons.splitByWs

internal class Day7 {

    class Hand(
        val cards: String,
        val ruleSet: RuleSet,
        val type: Type = ruleSet.determineHandType(cards)
    ) : Comparable<Hand> {

        override fun compareTo(other: Hand): Int {
            compareValues(type, other.type).let { if (it != 0) return it }
            return cards.asSequence()
                .zip(other.cards.asSequence())
                .map { (card, otherCard) -> ruleSet.getCardStrength(card) to ruleSet.getCardStrength(otherCard) }
                .map { (cardStrength, otherCardStrength) -> compareValues(cardStrength, otherCardStrength) }
                .firstOrNull { it != 0 } ?: 0
        }

        enum class Type {
            HIGH_CARD,
            ONE_PAIR,
            TWO_PAIR,
            THREE_OF_A_KIND,
            FULL_HOUSE,
            FOUR_OF_A_KIND,
            FIVE_OF_A_KIND
        }
    }

    fun solvePart1(input: String): Long = solve(input, Part1RuleSet())

    fun solvePart2(input: String): Long = solve(input, Part2RuleSet())

    fun solve(input: String, ruleSet: RuleSet) = input.lines()
        .map { it.splitByWs().let { (cards, bid) -> Hand(cards, ruleSet) to bid.toLong() } }
        .sortedBy { (hand, _) -> hand }
        .mapIndexed { index, (_, bid) -> ((index + 1) * bid) }
        .sum()

    sealed interface RuleSet {

        val cardStrengths: List<Char>
        fun determineHandType(cards: String): Type
        fun getCardStrength(card: Char) = cardStrengths.indexOf(card)

        class Part1RuleSet : RuleSet {
            override val cardStrengths = listOf('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
            override fun determineHandType(cards: String): Type = cards.groupingBy { it }
                .eachCount()
                .values
                .let {
                    when {
                        5 in it -> FIVE_OF_A_KIND
                        4 in it -> FOUR_OF_A_KIND
                        3 in it && 2 in it -> FULL_HOUSE
                        3 in it -> THREE_OF_A_KIND
                        it.count { it == 2 } == 2 -> TWO_PAIR
                        2 in it -> ONE_PAIR
                        it.size == 5 -> HIGH_CARD
                        else -> error("Undetermined hand type for: $it")
                    }
                }
        }

        class Part2RuleSet : RuleSet {
            override val cardStrengths = listOf('J', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'Q', 'K', 'A')
            override fun determineHandType(cards: String): Type = cards.groupingBy { it }
                .eachCount()
                .let {
                    val wildcards = it['J'] ?: 0
                    if (it.any { (card, count) -> (if (card == 'J') count else count + wildcards) == 5 }) return FIVE_OF_A_KIND
                    if (it.any { (card, count) -> (if (card == 'J') count else count + wildcards) == 4 }) return FOUR_OF_A_KIND
                    if ((it.values.any { it == 3 } && it.values.any { it == 2 }) || (it.values.count { it == 2 } == 2 && wildcards > 0)) return FULL_HOUSE
                    if (it.any { (card, count) -> (if (card == 'J') count else count + wildcards) == 3 }) return THREE_OF_A_KIND
                    if (it.count { (card, count) -> (if (card == 'J') count else count + wildcards) == 2 } == 2) return TWO_PAIR
                    if (it.any { (card, count) -> (if (card == 'J') count else count + wildcards) == 2 }) return ONE_PAIR
                    if (it.size == 5) return HIGH_CARD
                    error("Undetermined hand type for: $it")
                }
        }
    }
}
