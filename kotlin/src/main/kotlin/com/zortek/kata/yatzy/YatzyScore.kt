package com.zortek.kata.yatzy

enum class YatzyScore(private val scores: (DiceRoll) -> Int) {
    CHANCE({ it.sum() }),
    YATZY({ if (it.yatzy()) 50 else 0 }),
    ONES({ it.countDice(1) }),
    TWOS({ it.countDice(2) * 2 }),
    THREES({ it.countDice(3) * 3 }),
    FOURS({ it.countDice(4) * 4 }),
    FIVES({ it.countDice(5) * 5 }),
    SIXES({ it.countDice(6) * 6 }),
    PAIR(pair),
    TWO_PAIRS(twoPairs),
    THREE_OF_A_KIND(threeOfAKind),
    FOUR_OF_A_KIND(fourOfAKind),
    SMALL_STRAIGHT(smallStraight),
    LARGE_STRAIGHT(largeStraight),
    FULL_HOUSE(fullHouse);

    fun score(roll: DiceRoll) = scores(roll)
}

val pair: (DiceRoll) -> Int = { if (it.findPairs().isEmpty()) 0 else it.findPairs()[0]!! * 2 }

val twoPairs: (DiceRoll) -> Int =
    {
        if (it.findPairs().size >= 2) it.findPairs().map { it!! * 2 }.sum()
        else 0
    }

val fourOfAKind: (DiceRoll) -> Int = { it.getDiceWithCountGreaterThan(4) * 4 }
val smallStraight: (DiceRoll) -> Int = { if (it.isSmallStraight()) 15 else 0 }
val largeStraight: (DiceRoll) -> Int = { if (it.isLargeStraight()) 20 else 0 }
val fullHouse: (DiceRoll) -> Int = { if (it.isFullHouse()) it.sum() else 0 }
val threeOfAKind: (DiceRoll) -> Int = { it.getDiceWithCountGreaterThan(3) * 3 }