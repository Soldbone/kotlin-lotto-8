package lotto.constant.prompt

enum class OutputMessage(val text: String) {
    // 입력 프롬프트
    PURCHASE_AMOUNT_PROMPT("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요."),

    // 결과 출력
    NUMBER_OF_PURCHASES("%d개를 구매했습니다."),

    WINNING_STATISTICS("당첨 통계\n---"),
    WINNING_NORMAL("%d개 일치 (%,d원) - %d개"),
    WINNING_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다."),
    ERROR("[ERROR] %s");

    fun format(vararg args: Any): String = text.format(*args)
}
