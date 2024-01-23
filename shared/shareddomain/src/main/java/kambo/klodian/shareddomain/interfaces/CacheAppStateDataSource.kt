package kambo.klodian.shareddomain.interfaces

import kambo.klodian.shareddomain.entities.AppState
import kotlinx.coroutines.flow.Flow

interface CacheAppStateDataSource {
    val appState: Flow<AppState>
    fun update(appState: AppState)
}