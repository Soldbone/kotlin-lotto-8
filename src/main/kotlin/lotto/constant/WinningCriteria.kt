package lotto.constant

enum class WinningCriteria(val matchCount: Int, val hasBonus: Boolean, val prize: Int) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    companion object {
        fun of(matchCount: Int, hasBonus: Boolean): WinningCriteria {
            return when (matchCount) {
                6 -> FIRST
                5 if hasBonus -> SECOND
                5 -> THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}
