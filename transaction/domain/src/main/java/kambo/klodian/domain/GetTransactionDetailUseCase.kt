package kambo.klodian.domain

import javax.inject.Inject

interface GetTransactionDetailUseCase : suspend (String) -> Result<Transaction>

internal class GetTransactionDetailUseCaseImpl @Inject constructor(
    private val remoteTransactionDataSource: RemoteTransactionDataSource
) : GetTransactionDetailUseCase {

    override suspend operator fun invoke(transactionId: String): Result<Transaction> {
        return remoteTransactionDataSource.getTransactionDetail(transactionId)
    }
}