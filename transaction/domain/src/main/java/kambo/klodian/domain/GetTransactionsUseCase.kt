package kambo.klodian.domain

import kambo.klodian.domain.datasource.RemoteTransactionDataSource
import javax.inject.Inject


interface GetTransactionsUseCase : suspend () -> Result<List<Transaction>>

internal class GetTransactionsUseCaseImpl @Inject constructor(
    private val remoteTransactionDataSource: RemoteTransactionDataSource
) : GetTransactionsUseCase {

    override suspend operator fun invoke(): Result<List<Transaction>> {
        return remoteTransactionDataSource.getTransactions()
    }
}