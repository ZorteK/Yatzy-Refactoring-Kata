import com.zortek.kata.yatzy.DiceRoll.Companion.of
import com.zortek.kata.yatzy.YatzyScore.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


class YatzyTest {

    @Nested
    inner class `chance should` {
        @Test
        fun `scores sum of all dice`() {
            //given
            val expected = 15

            //when
            val actual = CHANCE.score(of(2, 3, 4, 5, 1))

            //then
            assertEquals(expected, actual)
        }
    }


    @Nested
    inner class `Yatzy  should  ` {
        @Test
        fun `scores  50  if  all  dices  are  equals`() {
            //given
            val expected = 50

            //when
            val actual: Int = YATZY.score(of(4, 4, 4, 4, 4))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores  0  if  all  dices  are  not  equals`() {
            //given
            val expected = 0

            //when
            val actual: Int = YATZY.score(of(6, 6, 6, 6, 3))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `Ones should ` {
        @Test
        fun `count number of one`() {
            //given
            val expected = 1

            //when
            val actual: Int = ONES.score(of(1, 2, 3, 4, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no one`() {
            //given
            val expected = 0

            //when
            val actual: Int = ONES.score(of(6, 2, 2, 4, 5))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `Twos should ` {
        @Test
        fun `count number of twos multiply by two`() {
            //given
            val expected = 4

            //when
            val actual: Int = TWOS.score(of(1, 2, 3, 2, 6))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no twos`() {
            //given
            val expected = 0

            //when
            val actual: Int = TWOS.score(of(3, 3, 3, 3, 3))

            //then
            assertEquals(expected, actual)
        }
    }


    @Nested
    inner class `Threes should ` {
        @Test
        fun `count number of threes multiply by threes`() {
            //given
            val expected = 6

            //when
            val actual: Int = THREES.score(of(1, 2, 3, 2, 3))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no threes`() {
            //given
            val expected = 0

            //when
            val actual: Int = THREES.score(of(4, 4, 4, 4, 4))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `Fours should ` {
        @Test
        fun `count number of fours multiply by fours`() {
            //given
            val expected = 12

            //when
            val actual: Int = FOURS.score(of(4, 4, 4, 5, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no four`() {
            //given
            val expected = 0

            //when
            val actual: Int = FOURS.score(of(5, 5, 5, 5, 5))

            //then
            assertEquals(expected, actual)
        }
    }


    @Nested
    inner class `Fives should ` {
        @Test
        fun `count number of fives multiply by fives`() {
            //given
            val expected = 10

            //when
            val actual: Int = FIVES.score(of(4, 4, 4, 5, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no fives`() {
            //given
            val expected = 0

            //when
            val actual: Int = FIVES.score(of(4, 4, 4, 4, 4))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `Sixes should ` {
        @Test
        fun `count number of sixes multiply by six`() {
            //given
            val expected = 18

            //when
            val actual: Int = SIXES.score(of(6, 5, 6, 6, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no six`() {
            //given
            val expected = 0

            //when
            val actual: Int = SIXES.score(of(4, 4, 4, 5, 5))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `One pair should ` {
        @Test
        fun `add pair value`() {
            //given
            val expected = 6

            //when
            val actual: Int = PAIR.score(of(3, 4, 3, 5, 6))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun  //TODO : check function rule when we have 2 pairs
                `find better pair and sum value`() {
            //given
            val expected = 8

            //when
            val actual: Int = PAIR.score(of(3, 3, 4, 4, 6))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no pair`() {
            //given
            val expected = 0

            //when
            val actual: Int = TWO_PAIRS.score(of(1, 2, 3, 4, 5))

            //then
            assertEquals(expected, actual)
        }
    }


    @Nested
    inner class `two pair should` {
        @Test
        fun `find pairs and sum value`() {
            //given
            val expected = 16

            //when
            val actual: Int = TWO_PAIRS.score(of(3, 3, 5, 4, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no two pairs`() {
            //given
            val expected = 0

            //when
            val actual: Int = TWO_PAIRS.score(of(3, 3, 5, 4, 3))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `three of a kind should` {
        @Test
        fun `find triple and sum value`() {
            //given
            val expected = 9

            //when
            val actual: Int = THREE_OF_A_KIND.score(of(3, 3, 3, 4, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `find triple and sum value for quadruplet`() {
            //given
            val expected = 9

            //when
            val actual: Int = THREE_OF_A_KIND.score(of(3, 3, 3, 3, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `score 0 if no two triple`() {
            //given
            val expected = 0

            //when
            val actual: Int = THREE_OF_A_KIND.score(of(3, 1, 5, 4, 3))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `four of a kind should` {
        @Test
        fun `find quadruplet and sum value`() {
            //given
            val expected = 12

            //when
            val actual: Int = FOUR_OF_A_KIND.score(of(3, 3, 3, 3, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `find triple and sum value for yatzy`() {
            //given
            val expected = 12

            //when
            val actual: Int = FOUR_OF_A_KIND.score(of(3, 3, 3, 3, 3))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `score 0 if no two quadruplet`() {
            //given
            val expected = 0

            //when
            val actual: Int = FOUR_OF_A_KIND.score(of(3, 1, 5, 4, 3))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `small straight should` {
        @Test
        @Disabled(
            """
            this test won't pass before refactoring
            Please check why
            Maybe the previous code was not compliant with the official rules https://fr.wikibooks.org/wiki/Bo%C3%AEte_%C3%A0_jeux/Yams
            """
        )
        fun `score 15 if small straight`() {
            //given
            val expected = 15

            //when
            val actual = SMALL_STRAIGHT.score(of(1, 2, 3, 4, 1))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `score 15 if small straight  us rules`() {
            //given
            val expected = 15

            //when
            val actual = SMALL_STRAIGHT.score(of(1, 2, 3, 4, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no small straight`() {
            //given
            val expected = 0

            //when
            val actual = SMALL_STRAIGHT.score(of(3, 1, 5, 4, 3))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `large straight should` {
        @Test
        @Disabled(
            """
            this test won't pass before refactoring
            Please check why
            Maybe the previous code was not compliant with the official rules https://fr.wikibooks.org/wiki/Bo%C3%AEte_%C3%A0_jeux/Yams
            """
        )
        fun `score 20 if large straight`() {
            //given
            val expected = 20

            //when
            val actual = LARGE_STRAIGHT.score(of(1, 2, 3, 4, 5))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 20 if large straight US rules`() {
            //given
            val expected = 20

            //when
            val actual = LARGE_STRAIGHT.score(of(2, 3, 4, 5, 6))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores 0 if no  small straight`() {
            //given
            val expected = 0

            //when
            val actual = LARGE_STRAIGHT.score(of(3, 1, 5, 4, 3))

            //then
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class `full house should` {
        @Test
        fun `sum value if full house`() {
            //given
            val expected = 18

            //when
            val actual = FULL_HOUSE.score(of(6, 2, 2, 2, 6))

            //then
            assertEquals(expected, actual)
        }

        @Test
        fun `scores0 if no full house`() {
            //given
            val expected = 0

            //when
            val actual = FULL_HOUSE.score(of(3, 1, 5, 4, 3))

            //then
            assertEquals(expected, actual)
        }
    }

}