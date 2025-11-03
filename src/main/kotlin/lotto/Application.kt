package lotto

import lotto.controller.LottoController
import lotto.view.OutputView

fun main() {
    // TODO: 프로그램 구현
    val lottoController = LottoController()

    var price: Int? = null
    do {
        price = lottoController.getPrice()
    } while (price == null)

    val lottos = lottoController.generateLotto(price)

    val lottoNumbers = lottoController.getLottoNumbers(lottos)
    OutputView.printLottoAmount(price)
    OutputView.printLottoNumbers(lottoNumbers)

    
}
