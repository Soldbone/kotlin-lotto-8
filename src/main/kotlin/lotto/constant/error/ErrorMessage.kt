package lotto.constant.error

import lotto.constant.LottoConstant

enum class ErrorMessage(val text: String) {
    UNEXPECTED_ERROR("UNEXPECTED ERROR"),

    // 입력
    NOT_A_NUMBER("숫자를 입력해 주세요."),

    // Lotto
    INVALID_LOTTO_AMOUNT("로또는 최소 1개 이상 구입해야 합니다."),
    INVALID_PURCHASE_AMOUNT("구매 금액은 ${LottoConstant.PRICE}원 이상이어야 합니다.")
}
