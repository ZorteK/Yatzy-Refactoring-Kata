package com.zortek.kata.yatzy;

import java.util.List;

class YatzyScores {

    private YatzyScores() {
        throw new IllegalStateException("Utility class");
    }

    public static int chance(final DiceRoll diceRoll) {
        return diceRoll.sum();
    }

    public static int yatzy(final DiceRoll diceRoll) {
        if (diceRoll.yatzy()) {
            return 50;
        }
        return 0;
    }

    public static int ones(final DiceRoll diceRoll) {
        return diceRoll.countDice(1);
    }

    public static int twos(final DiceRoll diceRoll) {
        return diceRoll.countDice(2) * 2;
    }

    public static int threes(final DiceRoll diceRoll) {
        return diceRoll.countDice(3) * 3;
    }

    public static int fours(final DiceRoll diceRoll) {
        return diceRoll.countDice(4) * 4;
    }

    public static int fives(final DiceRoll diceRoll) {
        return diceRoll.countDice(5) * 5;
    }

    public static int sixes(final DiceRoll diceRoll) {
        return diceRoll.countDice(6) * 6;
    }

    public static int pair(final DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs();
        if (pairs.isEmpty()) {
            return 0;
        }  else {
            return pairs.get(0) * 2;
        }
    }

    public static int twoPairs(final DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs();
        if (pairs.size() >= 2) {
            return pairs.stream()
                    .mapToInt(pair -> pair * 2)
                    .sum();
        }
        return 0;
    }

    public static int threeOfAKind(final DiceRoll diceRoll) {
        return diceRoll.getDiceWithCountGreaterThan(3) * 3;
    }

    public static int fourOfAKind(final DiceRoll diceRoll) {
        return diceRoll.getDiceWithCountGreaterThan(4) * 4;
    }

    public static int smallStraight(final DiceRoll diceRoll) {
        if (diceRoll.isSmallStraight()) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(final DiceRoll diceRoll) {
        if (diceRoll.isLargeStraight()) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(final DiceRoll diceRoll) {
        if (diceRoll.isFullHouse()) {
            return diceRoll.sum();
        }
        return 0;
    }
}


