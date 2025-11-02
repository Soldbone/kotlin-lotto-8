package lotto.constants

enum class WinningRule(val prize: Int, val matchCount: Int, val bonusMatch: Boolean) {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    NONE(0, 0, false);
}
