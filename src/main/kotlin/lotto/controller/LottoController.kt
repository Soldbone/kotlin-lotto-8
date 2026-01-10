package lotto.controller

import lotto.constant.LottoConstant
import lotto.constant.error.ErrorMessage
import lotto.model.Lotto
import lotto.model.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun getPurchaseAmount(): Int {
        OutputView.displayPurchaseAmountPrompt()

        while (true) {
            try {
                val purchaseAmount =
                    InputView.read().toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.text)
                require(purchaseAmount >= LottoConstant.PRICE) { ErrorMessage.INVALID_PURCHASE_AMOUNT }
                return purchaseAmount
            } catch (e: IllegalArgumentException) {
                OutputView.displayError(e.message ?: ErrorMessage.UNEXPECTED_ERROR.text)
            }
        }
    }

    fun purchaseLottos(): List<Lotto> {
        val purchaseAmount = getPurchaseAmount()
        val amount = Lotto.getNumberOfPurchases(purchaseAmount)
        val lottoMachine = LottoMachine()
        val lottos = lottoMachine.drawLottos(amount)

        OutputView.displayPurchasedLottos(lottos)
        return lottos
    }

}