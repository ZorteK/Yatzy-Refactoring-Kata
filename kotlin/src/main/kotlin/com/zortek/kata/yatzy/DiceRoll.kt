package com.zortek.kata.yatzy

import java.util.stream.Stream

class DiceRoll(private val dice: List<Int>) {
    fun yatzy(): Boolean {
        return groupByValue()
            .values
            .any { it == 5 }
    }

    fun isFullHouse(): Boolean {
        val hasThreeOfAKind = getDiceWithCountGreaterThan(3) != 0
        val hasPair = !findPairs().isEmpty()
        val isYatzy = yatzy() //todo :it's debatable
        return hasThreeOfAKind && hasPair && !isYatzy
    }

    fun countDice(dice: Int): Int {
        return groupByValue()[dice] ?: 0
    }

    fun ones(roll: DiceRoll): Int {
        return roll.countDice(1)
    }

    fun twos(roll: DiceRoll): Int {
        return roll.countDice(2) * 2
    }

    fun threes(roll: DiceRoll): Int {
        return roll.countDice(3) * 3
    }

    fun fours(roll: DiceRoll): Int {
        return roll.countDice(4) * 4
    }

    fun fives(roll: DiceRoll): Int {
        return roll.countDice(5) * 5
    }

    fun sixes(roll: DiceRoll): Int {
        return roll.countDice(6) * 6
    }

    fun findPairs(): List<Int> {
        return filterNumberOfDiceGreaterThan(2)
            .sorted(Comparator.reverseOrder())
            .toList()
    }

    fun getDiceWithCountGreaterThan(n: Int) = filterNumberOfDiceGreaterThan(n)
        .findFirst()
        .orElse(0)!!

    fun sum() = dice.sum()

    fun isSmallStraight() = sort() == SMALL_STRAIGHT

    fun isLargeStraight() = sort() == LARGE_STRAIGHT

    private fun sort() = dice.sorted()

    private fun filterNumberOfDiceGreaterThan(n: Int): Stream<Int> {
        return groupByValue()
            .entries
            .stream()
            .filter { it.value >= n }
            .map { it.key }
    }

    private fun groupByValue(): Map<Int, Int> {
        return dice
            .groupingBy { it }
            .eachCount()
    }

    companion object {
        private val SMALL_STRAIGHT: List<Int> = listOf(1, 2, 3, 4, 5)
        private val LARGE_STRAIGHT: List<Int> = listOf(2, 3, 4, 5, 6)
        fun of(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) = DiceRoll(listOf(d1, d2, d3, d4, d5))
    }
}