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
}
