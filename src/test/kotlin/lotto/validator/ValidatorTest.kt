package lotto.validator

import lotto.validator.Validator.validatePrice
import lotto.validator.Validator.validateWinningNumbers
import lotto.validator.Validator.validateBonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["0", "F", "-1", " ", "", "1.1"])
    fun `금액이 양의 정수(숫자)가 아닌 경우 예외 테스트`(priceInput: String) {
        assertThrows<IllegalArgumentException> {
            try {
                validatePrice(priceInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["123", "1001", "1", "1999", "99999999", "00000001"])
    fun `금액이 1000원 단위로 나눠 떨어지지 않는 경우 예외 테스트`(priceInput: String) {
        assertThrows<IllegalArgumentException> {
            try {
                validatePrice(priceInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }
    }

    @Test
    fun `당첨 번호 숫자 범위에서 벗어난 경우 예외 테스트`() {
        val winningNumbersInput = listOf("1", "2", "3", "4", "5", "60")
        assertThrows<IllegalArgumentException> {
            try {
                validateWinningNumbers(winningNumbersInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }
    }

    @Test
    fun `중복되는 당첨 번호가 있는 경우 예외 테스트`() {
        val winningNumbersInput = listOf("1", "2", "3", "4", "5", "5")
        assertThrows<IllegalArgumentException> {
            try {
                validateWinningNumbers(winningNumbersInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }
    }

    @Test
    fun `뽑은 당첨 번호가 6개가 아닌 경우 예외 테스트`() {
        val winningNumbersInput = listOf("1", "2", "3", "4", "5")
        assertThrows<IllegalArgumentException> {
            try {
                validateWinningNumbers(winningNumbersInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }
    }

    @Test
    fun `당첨 번호가 숫자가 아닌 경우 예외 테스트`() {
        val winningNumbersInput = listOf("1", "2", "3", "4", "5", "")
        assertThrows<IllegalArgumentException> {
            try {
                validateWinningNumbers(winningNumbersInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "", "@", "O"]) // 알파벳 o
    fun `보너스 번호가 숫자가 아닌 경우 예외 테스트`(bonusInput: String) {
        assertThrows<IllegalArgumentException> {
            try {
                validateBonusNumber(bonusInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["3789", "0", "-1", "46"])
    fun `보너스 번호가 숫자 범위에서 벗어난 경우 예외 테스트`(bonusInput: String) {
        assertThrows<IllegalArgumentException> {
            try {
                validateBonusNumber(bonusInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
        }
    }
}
