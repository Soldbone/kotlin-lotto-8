package lotto.view

import lotto.constant.WinningCriteria
import lotto.constant.prompt.OutputMessage
import lotto.model.Lotto
import lotto.model.LottoResult

object OutputView {
    fun prompt(outputMessage: OutputMessage) {
        println(outputMessage.text)
    }

    fun displayPurchaseAmountPrompt() = prompt(OutputMessage.PURCHASE_AMOUNT_PROMPT)

    fun displayWinningNumbersPrompt() = prompt(OutputMessage.WINNING_NUMBERS_PROMPT)

    fun displayBonusNumberPrompt() = prompt(OutputMessage.BONUS_NUMBER_PROMPT)

    fun displayNumberOfPurchases(lottos: List<Lotto>) {
        println()
        println(OutputMessage.NUMBER_OF_PURCHASES.format(lottos.size))

        lottos.forEach { lotto -> println(lotto) }
    }

    fun displayWinningStatistics(lottoResult: LottoResult) {
        println()
        prompt(OutputMessage.WINNING_STATISTICS)

        val winningResult = lottoResult.produce()
        displayWinningResult(winningResult)
        displayTotalReturn()
    }

    // TODO: 구현 필
    fun displayWinningResult(winningResult: Map<WinningCriteria, Int>) {
        val sortedWinningResult = winningResult.toSortedMap(compareByDescending { it })

        sortedWinningResult.forEach { (rank, count) ->
            val message =
                if (rank.hasBonus) OutputMessage.WINNING_BONUS else OutputMessage.WINNING_NORMAL

            if (rank != WinningCriteria.NONE) {
                println(message.format(rank.matchCount, rank.prize, count))
            }

        }
    }

    // TODO: 구현 필
    fun displayTotalReturn() {}

    fun displayError(errorMessage: String): String = OutputMessage.ERROR.format(errorMessage)
}
