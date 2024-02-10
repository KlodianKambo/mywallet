package kambo.klodian.shareddomain.entities

sealed class AppState {
    object Overview: AppState()
    object Transactions: AppState()
    data class TransactionDetails (val transactionId: String): AppState()
}
