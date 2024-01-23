package kambo.klodian.home.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kambo.klodian.shareddomain.GetAppStateUpdatesUseCase
import kambo.klodian.shareddomain.entities.AppState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getAppStateUpdatesUseCase: GetAppStateUpdatesUseCase
) : ViewModel() {
    val appState: Flow<AppState> = getAppStateUpdatesUseCase()
}