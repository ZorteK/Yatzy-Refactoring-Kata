package com.zortek.kata.yatzy;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.zortek.kata.yatzy.YatzyHelper.countingInt;
import static java.util.Comparator.reverseOrder;
import static java.util.List.of;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;

public class DiceRoll {

    public static final List<Integer> SMALL_STRAIGHT = of(1, 2, 3, 4, 5);
    public static final List<Integer> LARGE_STRAIGHT = of(2, 3, 4, 5, 6);
    private final List<Integer> dice;

    public DiceRoll(final int d1, final int d2, final int d3, final int d4, final int d5) {
        this.dice = of(d1, d2, d3, d4, d5);
    }

    public boolean yatzy() {
        return groupByValue()
            .values()
            .stream()
            .anyMatch(count -> count == 5);
    }

    Map<Integer, Integer> groupByValue() {
        return dice
            .stream()
            .collect(groupingBy(identity(), countingInt));
    }

    boolean isFullHouse() {
        boolean hasThreeOfAKind = getDiceWithCountGreaterThan(3) != 0;
        boolean hasPair = !findPairs().isEmpty();
        boolean isYatzy = yatzy(); //todo :it's debatable
        return hasThreeOfAKind && hasPair && !isYatzy;
    }

    public int countDice(final int dice) {
        return groupByValue().getOrDefault(dice, 0);
    }

    public static int ones(final DiceRoll roll) {
        return roll.countDice(1);
    }

    public static int twos(final DiceRoll roll) {
        return roll.countDice(2) * 2;
    }

    public static int threes(final DiceRoll roll) {
        return roll.countDice(3) * 3;
    }

    public static int fours(final DiceRoll roll) {
        return roll.countDice(4) * 4;
    }

    public static int fives(final DiceRoll roll) {
        return roll.countDice(5) * 5;
    }

    public static int sixes(final DiceRoll roll) {
        return roll.countDice(6) * 6;
    }

    private Stream<Integer> filterNumberOfDiceGreaterThan(final int n) {
        return groupByValue().entrySet().stream()
            .filter(entry -> entry.getValue() >= n)
            .map(Map.Entry::getKey);
    }

    public List<Integer> findPairs() {
        return filterNumberOfDiceGreaterThan(2)
            .sorted(reverseOrder())
            .toList();
    }

    public int getDiceWithCountGreaterThan(final int n) {
        return filterNumberOfDiceGreaterThan(n)
            .findFirst()
            .orElse(0);
    }

    public int sum() {
        return dice
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public boolean isSmallStraight() {
        return sort().equals(SMALL_STRAIGHT);
    }

    public boolean isLargeStraight() {
        return sort().equals(LARGE_STRAIGHT);
    }

    private List<Integer> sort() {
        return dice
            .stream()
            .sorted()
            .toList();
    }

}
