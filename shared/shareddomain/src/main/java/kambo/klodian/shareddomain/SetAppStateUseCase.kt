package kambo.klodian.shareddomain

import kambo.klodian.shareddomain.entities.AppState
import kambo.klodian.shareddomain.interfaces.CacheAppStateDataSource
import javax.inject.Inject

class SetAppStateUseCase @Inject constructor(
    private val cacheAppStateDataSource: CacheAppStateDataSource
) {
    operator fun invoke(appState: AppState) = cacheAppStateDataSource.update(appState)
}