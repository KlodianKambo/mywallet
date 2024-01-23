package kambo.klodian.domain.datasource

import kambo.klodian.domain.Transaction

interface RemoteTransactionDataSource {
    suspend fun getTransactions(): Result<List<Transaction>>
}