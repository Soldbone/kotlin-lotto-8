package lotto.model

import lotto.constant.LottoConstant
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    private lateinit var lottoMachine: LottoMachine

    @BeforeEach
    fun setup() {
        lottoMachine = LottoMachine()
    }

    @Test
    fun `drawLotto()로 생성한 로또 출력의 콤마 개수는 선택 가능한 숫자 개수보다 1개 적다`() {
        val lotto = lottoMachine.drawLotto()
        assertEquals(lotto.toString().count { it == ',' }, LottoConstant.NUMBER_OF_CHOICES - 1)
    }

    @Test
    fun `drawLottos()로 생성한 로또의 개수는 인자로 준 amount의 수와 일치해야 한다`() {
        val amount = 5
        val lottos = lottoMachine.drawLottos(amount)
        assertEquals(lottos.size, amount)
    }

    @Test
    fun `drawLottos()의 인자가 1 미만의 수라면 오류가 발생한다`() {
        val amount = 0
        assertThrows<IllegalArgumentException> {
            lottoMachine.drawLottos(amount)
        }
    }
}
