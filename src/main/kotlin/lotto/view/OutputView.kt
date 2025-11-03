package lotto.view

import lotto.constants.ErrorMessage
import lotto.constants.OutputMessage
import lotto.constants.WinningRule

object OutputView {
    fun printLottoAmount(amount: Int) {
        val amountPhrase = amount.toString()
        println()
        println(OutputMessage.AMOUNT.format(amountPhrase))
    }

    // Lotto를 직접 사용하지 않기 위해 List로 포장
    fun printLottoNumbers(lottoNumbers: List<String>) {
        lottoNumbers.forEach { lottoNumber ->
            println(lottoNumber)
        }
    }

    fun printResult(statistics: Map<WinningRule, Int>) {
        println()
        println(OutputMessage.PRE_STATISTICS)
        println(OutputMessage.SEPARATOR)
        val winningTiers = WinningRule.entries
            .filter { it != WinningRule.NONE }
            .reversed()
        winningTiers.forEach { rule ->
            val count = statistics.getOrDefault(rule, 0)
            val bonusText = if (rule == WinningRule.SECOND) OutputMessage.BONUS_TEXT else ""
            println(OutputMessage.RESULT.format(rule.matchCount, bonusText, rule.prize, count))
        }
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println(OutputMessage.RATE_OF_RETURN.format(rateOfReturn))
    }

    fun printErrorMessage(message: String?) {
        println(message?.format(OutputMessage.PRE_STATISTICS, message))
    }
}
