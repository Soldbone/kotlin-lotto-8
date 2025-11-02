package lotto.controller

import lotto.validator.Validator
import lotto.view.InputView

class LottoController {
    fun getPrice(): Int? {
        val priceInput = InputView.readPrice()

        try {
            Validator.validatePrice(priceInput)
            return priceInput.toInt()
        } catch (e: IllegalArgumentException) {
            // TODO: 출력 기능 구현 후 대체 필요
            println(e.message)
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
            println(e.message)
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
            println(e.message)
        }
        return null
    }
}
