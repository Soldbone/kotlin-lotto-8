package lotto.model

import lotto.constant.LottoConstant
import lotto.constant.WinningCriteria

class LottoResult(private val lottos: List<Lotto>, private val winningInfo: Pair<Lotto, Int>) {
    fun produce(): Map<WinningCriteria, Int> {
        val (winningLotto, bonusNumber) = winningInfo
        val incompleteWinningResult = lottos.groupingBy { it.checkWinning(winningLotto, bonusNumber) }.eachCount()
        val winningResult = WinningCriteria.entries.associateWith { incompleteWinningResult[it] ?: 0 }
        return winningResult
    }

    fun getRateOfReturn(winningResult: Map<WinningCriteria, Int>): Double {
        val purchaseAmount = (winningResult.values.sum() * LottoConstant.PRICE).toDouble()
        val total = getTotalPrize(winningResult)
        return total / purchaseAmount * 100
    }

    private fun getTotalPrize(winningResult: Map<WinningCriteria, Int>): Long {
        var total = 0L
        winningResult.forEach { (rank, count) ->
            total += rank.prize * count
        }
        return total
    }
}
