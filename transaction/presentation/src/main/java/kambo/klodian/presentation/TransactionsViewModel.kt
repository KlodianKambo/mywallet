package kambo.klodian.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kambo.klodian.domain.GetTransactionsUseCase
import kambo.klodian.domain.Transaction
import kambo.klodian.presentation.model.UiTransaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    private val _transactionsFlow = MutableStateFlow<List<UiTransaction>>(emptyList())
    val transactionsFlow: Flow<List<UiTransaction>> = _transactionsFlow

    fun fetchTransactions() {
        viewModelScope.launch {
            getTransactionsUseCase()
                .onSuccess {
                    _transactionsFlow.emit(
                        it.map {
                            it.toUiTransaction(dateFormatter.format(it.date))
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
            // todo
        }
    }

    private fun Transaction.toUiTransaction(formattedDate: String): UiTransaction {
        return UiTransaction(
            id = id,
            formattedDate = formattedDate,
            description = description,
            emitter = emitter
        )
    }
}