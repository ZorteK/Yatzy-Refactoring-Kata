package com.zortek.kata.yatzy;

import java.util.function.Function;

public enum Category {
    CHANCE(YatzyScores::chance),
    YATZY(YatzyScores::yatzy),
    ONES(YatzyScores::ones),
    TWOS(YatzyScores::twos),
    THREES(YatzyScores::threes),
    FOURS(YatzyScores::fours),
    FIVES(YatzyScores::fives),
    SIXES(YatzyScores::sixes),
    PAIR(YatzyScores::pair),
    TWO_PAIRS(YatzyScores::twoPairs),
    THREE_OF_A_KIND(YatzyScores::threeOfAKind),
    FOUR_OF_A_KIND(YatzyScores::fourOfAKind),
    SMALL_STRAIGHT(YatzyScores::smallStraight),
    LARGE_STRAIGHT(YatzyScores::largeStraight),
    FULL_HOUSE(YatzyScores::fullHouse);

    private final Function<DiceRoll, Integer> scoreFunction;

    Category(final Function<DiceRoll, Integer> scoreFunction) {
        this.scoreFunction = scoreFunction;
    }

    public int score(final DiceRoll roll) {
        return this.scoreFunction.apply(roll);
    }
}
