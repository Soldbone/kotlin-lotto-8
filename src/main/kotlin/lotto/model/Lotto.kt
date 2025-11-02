package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    // TODO: 추가 기능 구현
    fun countWinningNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun hasBonusNumber(bonus: Int): Boolean {
        return numbers.contains(bonus)
    }
}
