package lotto.model

import lotto.constant.WinningCriteria

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
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
}
