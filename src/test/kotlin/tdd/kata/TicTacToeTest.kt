/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tdd.kata

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TicTacToeTest {

    @Test
    fun thatGameIsNotOverAtTheBeginning() {
        val ticTacToe = TicTacToe()

        assertFalse(ticTacToe.hasGameFinished())
    }

    @Test
    fun thatGameIsOverWhenEverythingIsTaken() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(1, 1, 1), arrayOf(1, 1, 1), arrayOf(1, 1, 1)))

        assertTrue(ticTacToe.hasGameFinished())
    }

    @Test
    fun aGameIsNotOverWhenAllFieldsInAColumnAreNotTakenByAPlayer() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(1, -1, 1), arrayOf(0, 0, 0), arrayOf(0, 0, 1)))

        assertFalse(ticTacToe.hasGameFinished())
    }

    @Test
    fun aGameIsNotOverWhenAllFieldsInAColumnAreTakenByDifferentPlayers() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(1, -1, 1), arrayOf(-1, 1, -1), arrayOf(0, 0, 0)))

        assertFalse(ticTacToe.hasGameFinished())
    }

    @Test
    fun aGameIsOverWhenAllFieldsInAColumnAreTakenByAPlayer() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(1, 1, 1), arrayOf(0, 0, 1), arrayOf(0, 0, 1)))

        assertTrue(ticTacToe.hasGameFinished())
    }

    @Test
    fun aGameIsOverWhenAllFieldsInARowAreTakenByAPlayer() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(1, 1, 1), arrayOf(0, 0, 0), arrayOf(0, 0, 0)))

        assertTrue(ticTacToe.hasGameFinished())
    }

    @Test
    fun aGameIsOverWhenAllFieldsInAnotherRowAreTakenByAPlayer() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(0, 0, 0), arrayOf(1, 1, 1), arrayOf(0, 0, 0)))

        assertTrue(ticTacToe.hasGameFinished())
    }

    @Test
    fun aGameIsOverWhenADiagonalIsTakeByOnePlayer() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(1, 0, 0), arrayOf(0, 1, 0), arrayOf(0, 0, 1)))

        assertTrue(ticTacToe.hasGameFinished())
    }

    @Test
    fun playerOnlyCannotTakeAFieldIfHasBeenAlreadyTaken() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(1, 0, 0), arrayOf(0, 1, 0), arrayOf(0, 0, 1)))

        val take = ticTacToe.take(0, 0, 1)

        assertFalse(take)
    }


    @Test
    fun playerOnlyCanTakeAFieldIfHasNotBeenTaken() {
        val ticTacToe = TicTacToe(arrayOf(arrayOf(1, 0, 0), arrayOf(1, 1, 1), arrayOf(1, 1, 1)))

        val take = ticTacToe.take(0, 1, 1)

        assertTrue(take)
    }
}
