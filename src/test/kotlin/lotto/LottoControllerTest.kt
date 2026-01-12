package lotto

import lotto.controller.LottoController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class LottoControllerTest {
    @ParameterizedTest
    @EmptySource
    fun `구입 금액 입력이 Empty면 검증 함수에서 null을 반환한다`(input: String) {
        assertEquals(null, lottoController.validatePurchaseAmount(input))
    }

    @ParameterizedTest
    @ValueSource(strings = [",", ";", "1,000", "-", "-1000"])
    fun `구입 금액 입력이 숫자가 아니면 검증 함수에서 null을 반환한다`(input: String) {
        assertEquals(null, lottoController.validatePurchaseAmount(input))
    }

    companion object {
        val lottoController = LottoController()
    }
}
