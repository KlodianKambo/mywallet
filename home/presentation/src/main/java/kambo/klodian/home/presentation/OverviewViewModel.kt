package kambo.klodian.home.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kambo.klodian.shareddomain.SetAppStateUseCase
import kambo.klodian.shareddomain.entities.AppState
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val setAppStateUseCase: SetAppStateUseCase
): ViewModel() {
    fun submitData(){
        setAppStateUseCase(AppState.Transactions)
    }
}