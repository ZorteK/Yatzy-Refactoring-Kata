import com.zortek.kata.yatzy.DiceRoll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.zortek.kata.yatzy.Category.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Nested
    class Chance_should_ {
        @Test
        void scores_sum_of_all_dice() {
            //given
            final int expected = 15;

            //when
            final int actual = CHANCE.score(new DiceRoll(2, 3, 4, 5, 1));

            //then
            assertEquals(expected, actual);
        }

        @Test
            //TODO remove this unnecessary test
        void scores_sum_of_all_dice_2() {
            //given
            final int expected = 16;

            //when
            final int actual = CHANCE.score(new DiceRoll(3, 3, 4, 5, 1));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Yatzy_should_ {
        @Test
        void scores_50_if_all_dices_are_equals() {
            //given
            final int expected = 50;

            //when
            final int actual = YATZY.score(new DiceRoll(4, 4, 4, 4, 4));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_all_dices_are_not_equals() {
            //given
            final int expected = 0;

            //when
            final int actual = YATZY.score(new DiceRoll(6, 6, 6, 6, 3));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Ones_should_ {
        @Test
        void count_number_of_one() {
            //given
            final int expected = 1;

            //when
            final int actual = ONES.score(new DiceRoll(1, 2, 3, 4, 5));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_no_one() {
            //given
            final int expected = 0;

            //when
            final int actual = ONES.score(new DiceRoll(6, 2, 2, 4, 5));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Twos_should_ {
        @Test
        void count_number_of_twos_multiply_by_two() {
            //given
            final int expected = 4;

            //when
            final int actual = TWOS.score(new DiceRoll(1, 2, 3, 2, 6));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_no_twos() {
            //given
            final int expected = 0;

            //when
            final int actual = TWOS.score(new DiceRoll(3, 3, 3, 3, 3));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Threes_should_ {
        @Test
        void count_number_of_threes_multiply_by_threes() {
            //given
            final int expected = 6;

            //when
            final int actual = THREES.score(new DiceRoll(1, 2, 3, 2, 3));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_no_threes() {
            //given
            final int expected = 0;

            //when
            final int actual = THREES.score(new DiceRoll(4, 4, 4, 4, 4));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Fours_should_ {
        @Test
        void count_number_of_fours_multiply_by_fours() {
            //given
            final int expected = 12;

            //when
            final int actual = FOURS.score(new DiceRoll(4, 4, 4, 5, 5));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_no_four() {
            //given
            final int expected = 0;

            //when
            final int actual = FOURS.score(new DiceRoll(5, 5, 5, 5, 5));

            //then
            assertEquals(expected, actual);
        }
    }


    @Nested
    class Fives_should_ {
        @Test
        void count_number_of_fives_multiply_by_fives() {
            //given
            final int expected = 10;

            //when
            final int actual = FIVES.score(new DiceRoll(4, 4, 4, 5, 5));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_no_fives() {
            //given
            final int expected = 0;

            //when
            final int actual = FIVES.score(new DiceRoll(4, 4, 4, 4, 4));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Sixes_should_ {
        @Test
        void count_number_of_sixes_multiply_by_sixes() {
            //given
            final int expected = 18;

            //when
            final int actual = SIXES.score(new DiceRoll(6, 5, 6, 6, 5));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_no_fives() {
            //given
            final int expected = 0;

            //when
            final int actual = SIXES.score(new DiceRoll(4, 4, 4, 5, 5));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class One_pair_should_ {
        @Test
        void find_pair_and_sum_value() {
            //given
            final int expected = 6;

            //when
            final int actual = PAIR.score(new DiceRoll(3, 4, 3, 5, 6));

            //then
            assertEquals(expected, actual);
        }

        @Test
            //TODO : check function rule when we have 2 pairs
        void find_better_pair_and_sum_value() {
            //given
            final int expected = 8;

            //when
            final int actual = PAIR.score(new DiceRoll(3, 3, 4, 4, 6));

            //then
            assertEquals(expected, actual);
        }


        @Test
        void scores_0_if_no_pair() {
            //given
            final int expected = 0;

            //when
            final int actual = TWO_PAIRS.score(new DiceRoll(1, 2, 3, 4, 5));

            //then
            assertEquals(expected, actual);
        }
    }


    @Nested
    class Two_pair_should_ {
        @Test
        void find_pairs_and_sum_value() {
            //given
            final int expected = 16;

            //when
            final int actual = TWO_PAIRS.score(new DiceRoll(3, 3, 5, 4, 5));

            //then
            assertEquals(expected, actual);
        }


        @Test
        void scores_0_if_no_two_pairs() {
            //given
            final int expected = 0;

            //when
            final int actual = TWO_PAIRS.score(new DiceRoll(3, 3, 5, 4, 3));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Three_of_a_kind_should_ {
        @Test
        void find_triple_and_sum_value() {
            //given
            final int expected = 9;

            //when
            final int actual = THREE_OF_A_KIND.score(new DiceRoll(3, 3, 3, 4, 5));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void find_triple_and_sum_value_for_quadruplet() {
            //given
            final int expected = 9;

            //when
            final int actual = THREE_OF_A_KIND.score(new DiceRoll(3, 3, 3, 3, 5));

            //then
            assertEquals(expected, actual);
        }


        @Test
        void scores_0_if_no_two_triple() {
            //given
            final int expected = 0;

            //when
            final int actual = THREE_OF_A_KIND.score(new DiceRoll(3, 1, 5, 4, 3));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Four_of_a_kind_should_ {
        @Test
        void find_quadruplet_and_sum_value() {
            //given
            final int expected = 12;

            //when
            final int actual = FOUR_OF_A_KIND.score(new DiceRoll(3, 3, 3, 3, 5));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void find_triple_and_sum_value_for_yatzy() {
            //given
            final int expected = 12;

            //when
            final int actual = FOUR_OF_A_KIND.score(new DiceRoll(3, 3, 3, 3, 3));

            //then
            assertEquals(expected, actual);
        }


        @Test
        void scores_0_if_no_two_quadruplet() {
            //given
            final int expected = 0;

            //when
            final int actual = FOUR_OF_A_KIND.score(new DiceRoll(3, 1, 5, 4, 3));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class SmallStraight_should_ {
        @Test
        @Disabled("""
            this test won't pass before refactoring,
            Please check why
            Maybe the previous code was not compliant with the official rules https://fr.wikibooks.org/wiki/Bo%C3%AEte_%C3%A0_jeux/Yams
            """)
        void score_15_if_small_straight() {
            //given
            final int expected = 15;

            //when
            final int actual = SMALL_STRAIGHT.score(new DiceRoll(1, 2, 3, 4, 1));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void score_15_if_small_straight_US_rules() {
            //given
            final int expected = 15;

            //when
            final int actual = SMALL_STRAIGHT.score(new DiceRoll(1, 2, 3, 4, 5));

            //then
            assertEquals(expected, actual);
        }


        @Test
        void scores_0_if_no_SmallStraight() {
            //given
            final int expected = 0;

            //when
            final int actual = SMALL_STRAIGHT.score(new DiceRoll(3, 1, 5, 4, 3));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class LargeStraight_should_ {
        @Test
        @Disabled("""
            this test won't pass before refactoring
            Please check why
            Maybe the previous code was not compliant with the official rules https://fr.wikibooks.org/wiki/Bo%C3%AEte_%C3%A0_jeux/Yams
            """)
        void score_20_if_large_straight() {
            //given
            final int expected = 20;

            //when
            final int actual = LARGE_STRAIGHT.score(new DiceRoll(1, 2, 3, 4, 5));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void score_20_if_large_straight_US_Rules() {
            //given
            final int expected = 20;

            //when
            final int actual = LARGE_STRAIGHT.score(new DiceRoll(2, 3, 4, 5, 6));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_no_SmallStraight() {
            //given
            final int expected = 0;

            //when
            final int actual = LARGE_STRAIGHT.score(new DiceRoll(3, 1, 5, 4, 3));

            //then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class FullHouse_should_ {
        @Test
        void sum_value_if_full_house() {
            //given
            final int expected = 18;

            //when
            final int actual = FULL_HOUSE.score(new DiceRoll(6, 2, 2, 2, 6));

            //then
            assertEquals(expected, actual);
        }

        @Test
        void scores_0_if_no_full_house() {
            //given
            final int expected = 0;

            //when
            final int actual = FULL_HOUSE.score(new DiceRoll(3, 1, 5, 4, 3));

            //then
            assertEquals(expected, actual);
        }
    }
}
