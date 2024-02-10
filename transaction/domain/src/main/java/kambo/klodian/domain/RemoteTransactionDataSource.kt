package kambo.klodian.domain


interface RemoteTransactionDataSource {
    suspend fun getTransactions(): Result<List<Transaction>>
    suspend fun getTransactionDetail(transactionId: String): Result<Transaction>
}