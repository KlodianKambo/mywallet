package kambo.klodian.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kambo.klodian.presentation.UiDateFormatter
import kambo.klodian.presentation.UiDateFormatterImpl
import java.util.Locale
import java.util.TimeZone


@InstallIn(SingletonComponent::class)
@Module
class UiModule {

    @Provides
    internal fun provideUiDateFormatter(): UiDateFormatter =
        UiDateFormatterImpl(
            locale = Locale.getDefault(),
            zoneId = TimeZone.getDefault().toZoneId()
        )
}