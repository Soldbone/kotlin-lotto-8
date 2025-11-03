package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constants
import lotto.constants.WinningRule
import lotto.model.Lotto
import lotto.validator.Validator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun getPrice(): Int? {
        val priceInput = InputView.readPrice()

        try {
            Validator.validatePrice(priceInput)
            return priceInput.toInt()
        } catch (e: IllegalArgumentException) {
            // TODO: 출력 기능 구현 후 대체 필요
            OutputView.printErrorMessage(e.message)
        }
        return null
    }

    fun getWinningNumbers(): List<Int>? {
        val winningNumbersInput = InputView.readWinningNumbers()
        val splitWinningNumbersInput = winningNumbersInput.split(',')
        try {
            Validator.validateWinningNumbers(splitWinningNumbersInput)
            val winningNumbers = splitWinningNumbersInput.map { numbersInput ->
                val winningNumber = numbersInput.toInt()
                winningNumber
            }
            return winningNumbers
        } catch (e: IllegalArgumentException) {
            // TODO: 출력 기능 구현 후 대체 필요
            OutputView.printErrorMessage(e.message)
        }
        return null
    }

    fun getBonusNumber(): Int? {
        val bonusNumberInput = InputView.readBonusNumber()
        try {
            Validator.validateBonusNumber(bonusNumberInput)
            return bonusNumberInput.toInt()
        } catch (e: IllegalArgumentException) {
            // TODO: 출력 기능 구현 후 대체 필요
            OutputView.printErrorMessage(e.message)
        }
        return null
    }

    fun getLottoAmount(price: Int): Int {
        return price / Constants.UNIT_PRICE
    }

    fun generateLotto(price: Int): List<Lotto> {
        val amount = getLottoAmount(Constants.UNIT_PRICE)
        val lottoList = mutableListOf<Lotto>()
        repeat(amount) {
            val nums = Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUM, Constants.MAX_LOTTO_NUM, Constants.NUM_OF_CHOICES
            )
            val sortedNums = nums.sorted()
            lottoList.add(Lotto(sortedNums))
        }
        return lottoList.toList()
    }

    fun generateWinningList(winningNumbers: List<Int>, bonusNumber: Int): List<Int> {
        val winningList = mutableListOf<Int>()
        winningList.addAll(winningNumbers)
        winningList.add(bonusNumber)
        return winningList.toList()
    }

    fun getPrizeTier(
        winningNumbers: List<Int>,
        bonusNumber: Int,
        lotto: Lotto,
    ): WinningRule {
        val matchCount = lotto.countWinningNumbers(winningNumbers)
        val hasBonus = lotto.hasBonusNumber(bonusNumber)
        return when (matchCount) {
            6 -> WinningRule.FIRST
            5 -> {
                if (hasBonus) WinningRule.SECOND else WinningRule.THIRD
            }

            4 -> WinningRule.FOURTH
            3 -> WinningRule.FIFTH
            else -> WinningRule.NONE
        }
    }

    fun generateResult(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): Map<WinningRule, Int> {
        val statistics = WinningRule.entries.associateWith { 0 }.toMutableMap()
        lottos.forEach { lotto ->
            val rule = getPrizeTier(winningNumbers, bonusNumber, lotto)
            statistics[rule] = statistics.getOrDefault(rule, 0) + 1
        }
        return statistics
    }

    fun calculateRateOfReturn(statistics: Map<WinningRule, Int>, price: Int): Double {
        var totalPrize = 0L
        statistics.forEach { (rule, count) ->
            if (rule != WinningRule.NONE) totalPrize += rule.prize.toLong()
        }
        return (totalPrize.toDouble() / price.toDouble()) * 100 // 반올림은 출력 시 포매팅 활용
    }
}
