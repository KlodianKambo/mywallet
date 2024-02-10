package kambo.klodian.presentation.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kambo.klodian.domain.GetTransactionsUseCase
import kambo.klodian.domain.Transaction
import kambo.klodian.presentation.UiDateFormatter
import kambo.klodian.presentation.model.UiTransaction
import kambo.klodian.presentation.model.toUiTransaction
import kambo.klodian.shareddomain.SetAppStateUseCase
import kambo.klodian.shareddomain.entities.AppState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val getTransactionsUseCase: GetTransactionsUseCase,
    private val setAppStateUseCase: SetAppStateUseCase,
    private val uiDateFormatter: UiDateFormatter
) : ViewModel() {


    private val _transactionsFlow = MutableStateFlow<List<UiTransaction>>(emptyList())
    val transactionsFlow: Flow<List<UiTransaction>> = _transactionsFlow

    fun fetchTransactions() {
        viewModelScope.launch {
            getTransactionsUseCase()
                .onSuccess {
                    _transactionsFlow.emit(
                        it.map {
                            it.toUiTransaction(uiDateFormatter.formatToSimpleDate(it.date))
                        })
                }
                .onFailure {
                    // TODO
                }
        }
    }

    fun transactionSelected(uiTransaction: UiTransaction) {
        _transactionsFlow.value.firstOrNull {
            uiTransaction.id == it.id
        }?.let {
            setAppStateUseCase(AppState.TransactionDetails(it.id))
        }
    }
}