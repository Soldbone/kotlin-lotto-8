package lotto.constants

enum class ErrorMessage(val errMsg: String) {
    NOT_A_NUMBER("올바른 숫자를 입력해주세요."),
    NOT_A_POSITIVE_NUMBER("양의 정수를 입력해주세요."),
    UNIT_MISMATCH("금액은 1,000원 단위여야 합니다."),
    DUPLICATE_VALUE("로또 번호는 중복될 수 없습니다."),
    OUT_OF_CHOICES_LIMIT("로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
}
