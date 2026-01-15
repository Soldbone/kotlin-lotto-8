package lotto.controller

import lotto.constant.LottoConstant
import lotto.constant.error.ErrorMessage
import lotto.model.Lotto
import lotto.model.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun getPurchaseAmount(): Int {
        var validatedPurchaseAmount: Int?
        do {
            OutputView.displayPurchaseAmountPrompt()
            val purchaseAmount = InputView.read()
            validatedPurchaseAmount = validatePurchaseAmount(purchaseAmount)
        } while (validatedPurchaseAmount == null)
        return validatedPurchaseAmount
    }

    // 구입 금액 검증
    fun validatePurchaseAmount(purchaseAmount: String): Int? {
        try {
            val validatedPurchaseAmount =
                purchaseAmount.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.text)
            require(validatedPurchaseAmount % LottoConstant.PRICE == 0) { ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT }
            require(validatedPurchaseAmount >= LottoConstant.PRICE) { ErrorMessage.INSUFFICIENT_MINIMUM_AMOUNT }
            return validatedPurchaseAmount
        } catch (e: IllegalArgumentException) {
            OutputView.displayError(e.message ?: ErrorMessage.UNEXPECTED_ERROR.text)
            return null
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
