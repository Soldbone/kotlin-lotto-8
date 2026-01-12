package lotto.model

import lotto.constant.WinningCriteria
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    fun `Lotto의 toString은 Lotto의 numbers 인스턴스 변수의 toString()과 같다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(numbers.toString(), lotto.toString())
    }

    @ParameterizedTest
    @MethodSource
    fun `현재 Lotto의 등수를 당첨 기준에 따라 반환한다`(
        lotto: Lotto,
        bonusNumber: Int,
        winningLotto: Lotto,
        winning: WinningCriteria,
    ) {
        Assertions.assertEquals(lotto.checkWinning(winningLotto, bonusNumber), winning)
    }

    companion object {
        @JvmStatic
        fun `현재 Lotto의 등수를 당첨 기준에 따라 반환한다`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    7,
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    WinningCriteria.FIRST
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    7,
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    WinningCriteria.SECOND
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 8)),
                    7,
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    WinningCriteria.THIRD
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 7, 9)),
                    7,
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    WinningCriteria.FOURTH
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 7, 8, 9)),
                    7,
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    WinningCriteria.FIFTH
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 7, 8, 9, 45)),
                    7,
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    WinningCriteria.NONE
                ),
            )
        }
    }
}
