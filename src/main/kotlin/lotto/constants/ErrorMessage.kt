package lotto.constants

enum class ErrorMessage(val errMsg: String) {
    NOT_A_NUMBER("%s올바른 숫자를 입력해주세요."),
    NOT_A_POSITIVE_NUMBER("%s양의 정수를 입력해주세요."),
    UNIT_MISMATCH("%s금액은 1,000원 단위여야 합니다."),
    DUPLICATE_VALUE("%s로또 번호는 중복될 수 없습니다."),
    OUT_OF_CHOICES_LIMIT("%s로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE("%s로또 번호는 1부터 45 사이의 숫자여야 합니다."),
}
