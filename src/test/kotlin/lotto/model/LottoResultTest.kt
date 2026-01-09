package lotto.model

import lotto.constant.WinningCriteria
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `produce는 당첨된 로또 등수와 그 개수의 Map을 반환한다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 11)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 7, 9)),
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
        )
        val winningInfo = winningLotto to bonusNumber
        val lottoResult = LottoResult(lottos, winningInfo).produce()
        val expected = mapOf(
            WinningCriteria.FIRST to 1, WinningCriteria.SECOND to 1, WinningCriteria.THIRD to 2,
            WinningCriteria.FOURTH to 1, WinningCriteria.FIFTH to 1, WinningCriteria.NONE to 0
        )
        assertEquals(expected, lottoResult)
    }

    @Test
    fun `getRateOfReturn()은 수익률을 반환한다`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 7, 8)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(1, 2, 7, 23, 35, 45)),
            Lotto(listOf(1, 2, 7, 27, 39, 41)),
            Lotto(listOf(1, 2, 7, 19, 40, 42)),
        )
        val winningInfo = winningLotto to bonusNumber
        val lottoResult = LottoResult(lottos, winningInfo)
        val winningResult = lottoResult.produce()
        val rateOfReturn = lottoResult.getRateOfReturn(winningResult)
        val expected = 1000.0
        assertEquals(expected, rateOfReturn)
    }
}
