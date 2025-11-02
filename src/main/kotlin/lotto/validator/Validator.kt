package lotto.validator

import lotto.constants.ErrorMessage

object Validator {
    private const val MIN_LOTTO_NUM = 1
    private const val MAX_LOTTO_NUM = 45
    private const val NUM_OF_CHOICES = 6
    private const val UNIT_PRICE = 1000

    fun validatePrice(priceInput: String) {
        val price = priceInput.toIntOrNull()
        require(price != null && price > 0) { ErrorMessage.NOT_A_POSITIVE_NUMBER.errMsg }
        require(price % UNIT_PRICE == 0) { ErrorMessage.UNIT_MISMATCH.errMsg }
    }

    fun validateWinningNumbers(winningNumberInput: List<String>) {
        require(winningNumberInput.size == NUM_OF_CHOICES) { ErrorMessage.OUT_OF_CHOICES_LIMIT.errMsg }

        require(winningNumberInput.size == winningNumberInput.toSet().size) {
            ErrorMessage.DUPLICATE_VALUE.errMsg
        }

        val winningNumbers = winningNumberInput.map { winningNumberInput ->
            val winningNumber = winningNumberInput.toIntOrNull()
            require(winningNumber != null) { ErrorMessage.NOT_A_NUMBER.errMsg }

            winningNumber
        }

        require(winningNumbers.all { it in (MIN_LOTTO_NUM..MAX_LOTTO_NUM) }) {
            ErrorMessage.OUT_OF_RANGE.errMsg
        }
    }

    fun validateBonusNumber(bonusInput: String) {
        val bonus = bonusInput.toIntOrNull()
        require(bonus != null) { ErrorMessage.NOT_A_NUMBER.errMsg }
        require(bonus in (MIN_LOTTO_NUM..MAX_LOTTO_NUM)) { ErrorMessage.OUT_OF_RANGE.errMsg }
    }
}
