package kambo.klodian.shareddomain

import kambo.klodian.shareddomain.datasource.CacheAppStateDataSource
import javax.inject.Inject

class GetAppStateUpdatesUseCase @Inject constructor(
    private val cacheAppStateDataSource: CacheAppStateDataSource
) {
    operator fun invoke() = cacheAppStateDataSource.appState
}


