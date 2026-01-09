package lotto.model

import lotto.constant.WinningCriteria

class LottoResult(private val lottos: List<Lotto>, private val winningInfo: Pair<Lotto, Int>) {
    fun produce(): Map<WinningCriteria, Int> {
        val (winningLotto, bonusNumber) = winningInfo
        val incompleteWinningResult = lottos.groupingBy { it.checkWinning(winningLotto, bonusNumber) }.eachCount()
        val winningResult = WinningCriteria.entries.associateWith { incompleteWinningResult[it] ?: 0 }
        return winningResult
    }
}
