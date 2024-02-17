package kambo.klodian.presentation

import java.util.Date

interface UiDateFormatter {
    fun formatToSimpleDate(date: Date): String
}
