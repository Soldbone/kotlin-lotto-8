package lotto.view

import lotto.constant.WinningCriteria
import lotto.constant.message.OutputMessage
import lotto.model.Lotto
import lotto.model.LottoResult

object OutputView {
    fun prompt(outputMessage: OutputMessage) {
        println(outputMessage.text)
    }

    fun displayPurchaseAmountPrompt() = prompt(OutputMessage.PURCHASE_AMOUNT_PROMPT)

    fun displayWinningNumbersPrompt() = prompt(OutputMessage.WINNING_NUMBERS_PROMPT)

    fun displayBonusNumberPrompt() = prompt(OutputMessage.BONUS_NUMBER_PROMPT)

    fun displayNumberOfPurchases(amount: Int) {
        println(OutputMessage.NUMBER_OF_PURCHASES.format(amount))
    }

    fun displayLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }

    fun displayPurchasedLottos(lottos: List<Lotto>) {
        println()
        displayNumberOfPurchases(lottos.size)
        displayLottos(lottos)
    }

    fun displayWinningStatistics(lottoResult: LottoResult) {
        println()
        prompt(OutputMessage.WINNING_STATISTICS)

        val winningResult = lottoResult.produce()
        val rateOfReturn = lottoResult.getRateOfReturn(winningResult)
        displayWinningResult(winningResult)
        displayRateOfReturn(rateOfReturn)
    }

    private fun displayWinningResult(winningResult: Map<WinningCriteria, Int>) {
        val sortedWinningResult = winningResult.toSortedMap(compareByDescending { it })

        sortedWinningResult.forEach { (rank, count) ->
            val message =
                if (rank.hasBonus) OutputMessage.WINNING_BONUS else OutputMessage.WINNING_NORMAL

            if (rank != WinningCriteria.NONE) {
                println(message.format(rank.matchCount, rank.prize, count))
            }

        }
    }

    private fun displayRateOfReturn(rateOfReturn: Double) {
        println(OutputMessage.RATE_OF_RETURN.format(rateOfReturn))
    }

    fun displayError(errorMessage: String): String = OutputMessage.ERROR.format(errorMessage)
}
