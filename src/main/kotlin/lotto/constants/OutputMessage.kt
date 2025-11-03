package lotto.constants

enum class OutputMessage(val msg: String) {
    AMOUNT("%s개를 구매했습니다."),
    PRE_STATISTICS("당첨 통계"),
    SEPARATOR("---"),
    BONUS_TEXT(", 보너스 볼 일치"),
    RESULT("%s개 일치%s (%,d원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%입니다."),
    ERROR_PREFIX("[ERROR] %s");

    fun format(vararg args: Any): String {
        return msg.format(args)
    }
}
