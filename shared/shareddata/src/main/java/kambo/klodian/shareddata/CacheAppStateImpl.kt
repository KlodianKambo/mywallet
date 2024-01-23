package kambo.klodian.shareddata

import kambo.klodian.shareddomain.entities.AppState
import kambo.klodian.shareddomain.interfaces.CacheAppStateDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
internal class CacheAppStateDataSourceImpl @Inject constructor() : CacheAppStateDataSource {
    private val _appState = MutableStateFlow<AppState>(AppState.Overview)
    override val appState: Flow<AppState> = _appState

    override fun update(appState: AppState) {
        _appState.tryEmit(appState)
    }
}