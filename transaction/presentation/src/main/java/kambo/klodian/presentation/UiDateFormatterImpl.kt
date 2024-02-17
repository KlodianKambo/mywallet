package kambo.klodian.presentation

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class UiDateFormatterImpl(
    private val locale: Locale,
    private val zoneId: ZoneId
) : UiDateFormatter {

    private fun getFormatter(pattern: String) = DateTimeFormatter
        .ofPattern(pattern)
        .withLocale(locale)
        .withZone(zoneId)


    override fun formatToSimpleDate(date: Date): String =
        getFormatter("dd/MM/yyyy")
            .format(date.toInstant())

}