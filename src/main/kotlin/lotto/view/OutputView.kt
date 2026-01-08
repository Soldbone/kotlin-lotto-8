package lotto.view

import lotto.constant.prompt.OutputMessage
import lotto.model.Lotto

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

    fun displayWinningStatistics() {
        println()
        prompt(OutputMessage.WINNING_STATISTICS)

        displayWinningResult()
        displayTotalReturn()
    }

    // TODO: 구현 필
    fun displayWinningResult() {}

    // TODO: 구현 필
    fun displayTotalReturn() {}

    fun displayError(errorMessage: String): String = OutputMessage.ERROR.format(errorMessage)
}
