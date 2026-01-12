package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.LottoConstant
import lotto.constant.error.ErrorMessage
import lotto.view.OutputView

class LottoMachine {
    fun drawLottos(amount: Int): List<Lotto> {
        require(amount > 0) { OutputView.displayError(ErrorMessage.INVALID_LOTTO_AMOUNT.text) }
        return List(amount) { drawLotto() }
    }

    fun drawLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            LottoConstant.START_NUMBER,
            LottoConstant.END_NUMBER,
            LottoConstant.SIZE
        )
        val sortedNumbers = numbers.sorted()
        val lotto = Lotto(sortedNumbers)
        return lotto
    }
}
