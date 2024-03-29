package kambo.klodian.domain

import javax.inject.Inject


interface GetTransactionsUseCase : suspend () -> Result<List<Transaction>>

internal class GetTransactionsUseCaseImpl @Inject constructor(
    private val remoteTransactionDataSource: RemoteTransactionDataSource
) : GetTransactionsUseCase {

    override suspend operator fun invoke(): Result<List<Transaction>> {
        return remoteTransactionDataSource.getTransactions()
    }
}

