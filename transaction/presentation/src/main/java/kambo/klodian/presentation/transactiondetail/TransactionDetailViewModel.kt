package kambo.klodian.presentation.transactiondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kambo.klodian.domain.GetTransactionDetailUseCase
import kambo.klodian.domain.GetTransactionsUseCase
import kambo.klodian.domain.Transaction
import kambo.klodian.presentation.UiDateFormatter
import kambo.klodian.presentation.model.UiTransaction
import kambo.klodian.presentation.model.toUiTransaction
import kambo.klodian.presentation.model.toUiTransactionDetail
import kambo.klodian.shareddomain.GetAppStateUpdatesUseCase
import kambo.klodian.shareddomain.entities.AppState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface UiTransactionDetailScreen {
    object Empty : UiTransactionDetailScreen

    data class UiTransactionDetail(
        val id: String,
        val formattedDate: String,
        val description: String,
        val emitter: String
    ) : UiTransactionDetailScreen
}

@HiltViewModel
class TransactionDetailViewModel @Inject constructor(
    private val getAppStateUpdatesUseCase: GetAppStateUpdatesUseCase,
    private val getTransactionDetailUseCase: GetTransactionDetailUseCase,
    private val uiDateFormatter: UiDateFormatter
) : ViewModel() {

    private val _transactionDetailFlow =
        MutableStateFlow<UiTransactionDetailScreen>(UiTransactionDetailScreen.Empty)

    val transactionDetailFlow: Flow<UiTransactionDetailScreen> = _transactionDetailFlow

    init {
        viewModelScope.launch {
            getAppStateUpdatesUseCase().collectLatest {
                when (it) {
                    is AppState.TransactionDetails -> {
                        getTransactionDetailUseCase(it.transactionId)
                            .onSuccess {
                                _transactionDetailFlow.emit(
                                    it.toUiTransactionDetail(
                                        uiDateFormatter.formatToSimpleDate(
                                            it.date
                                        )
                                    )
                                )
                            }
                    }

                    else -> {

                    }
                }
            }
        }
    }
}