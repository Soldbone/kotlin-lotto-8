package lotto.model

import lotto.constant.LottoConstant
import lotto.constant.WinningCriteria
import lotto.constant.error.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstant.SIZE) { ErrorMessage.INVALID_LOTTO_SIZE }
        require(numbers.toSet().size == LottoConstant.SIZE) { ErrorMessage.DUPLICATE_NUMBERS }
    }

    // TODO: 추가 기능 구현
    override fun toString(): String {
        return numbers.toString()
    }

    fun checkWinning(winningLotto: Lotto, bonusNumber: Int): WinningCriteria {
        val winningNumbers = winningLotto.numbers
        val matchedNumbers = numbers.intersect(winningNumbers)
        val matchCount = matchedNumbers.size
        val hasBonusNumber = numbers.contains(bonusNumber)
        val result = WinningCriteria.of(matchCount, hasBonusNumber)
        return result
    }

    companion object {
        fun getNumberOfPurchases(purchaseAmount: Int): Int {
            require(purchaseAmount >= LottoConstant.PRICE) { ErrorMessage.INSUFFICIENT_MINIMUM_AMOUNT }
            return purchaseAmount / LottoConstant.PRICE
        }
    }
}
