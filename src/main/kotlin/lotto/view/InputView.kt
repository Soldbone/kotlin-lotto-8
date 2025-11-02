package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.InputMessage

object InputView {
    private fun prompt(message: InputMessage): String {
        println(message.prompt)
        return Console.readLine() ?: ""
    }

    fun readPrice(): String = prompt(InputMessage.PRICE)

    fun readWinningNumbers(): String = prompt(InputMessage.WINNING_NUMBER)

    fun readBonusNumber(): String = prompt(InputMessage.BONUS_NUMBER)
}
