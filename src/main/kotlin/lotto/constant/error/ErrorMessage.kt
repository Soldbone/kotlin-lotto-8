package lotto.constant.error

import lotto.constant.LottoConstant

enum class ErrorMessage(val text: String) {
    UNEXPECTED_ERROR("UNEXPECTED ERROR"),

    // 입력
    NOT_A_NUMBER("숫자를 입력해 주세요."),

    // Lotto
    INVALID_LOTTO_AMOUNT("로또는 최소 ${LottoConstant.MIN_AMOUNT}개 이상 구입해야 합니다."),
    INSUFFICIENT_MINIMUM_AMOUNT("구입 금액은 ${LottoConstant.PRICE}원 이상이어야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 ${LottoConstant.PRICE}원 단위여야 합니다"),
    INVALID_LOTTO_SIZE("로또 번호는 ${LottoConstant.SIZE}개여야 합니다."),
    DUPLICATE_NUMBERS("로또 번호는 중복될 수 없습니다.");

    override fun toString(): String {
        return text
    }
}
