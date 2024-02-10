package kambo.klodian.presentation

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

interface UiDateFormatter {
    fun formatToSimpleDate(date: Date): String
}

class UiDateFormatterImpl(
    private val locale: Locale,
    private val zoneId: ZoneId
) : UiDateFormatter {

    private fun getFormatter(patter: String) = DateTimeFormatter
        .ofPattern(patter)
        .withLocale(locale)
        .withZone(zoneId)


    override fun formatToSimpleDate(date: Date) =
        getFormatter("dd/MM/yyyy")
            .format(date.toInstant())
}