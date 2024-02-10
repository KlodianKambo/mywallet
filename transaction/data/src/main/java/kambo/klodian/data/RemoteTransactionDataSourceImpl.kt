package kambo.klodian.data


import kambo.klodian.domain.RemoteTransactionDataSource
import kambo.klodian.domain.Transaction
import kotlinx.coroutines.delay
import java.util.Date
import javax.inject.Inject

class RemoteTransactionDataSourceImpl @Inject constructor() : RemoteTransactionDataSource {

    override suspend fun getTransactions(): Result<List<Transaction>> {
        delay(200)

        // TODO 1. mocked retrofit response

        // TODO 2. response success check

        // TODO 3. response transformation to domain entity
        return Result.success(mockedDomainReadyTransactions)
    }


    override suspend fun getTransactionDetail(transactionId: String): Result<Transaction> {
        delay(200)
        return mockedDomainReadyTransactions.firstOrNull { it.id == transactionId }?.let {
            Result.success(it)
        } ?: Result.failure(RuntimeException("Id not found $transactionId"))
    }
}

private val mockedDomainReadyTransactions =
    listOf(
        Transaction(
            id = "1",
            date = Date(System.currentTimeMillis()),
            description = "Amazon shopping",
            emitter = "AMAZON Inc."
        ),
        Transaction(
            id = "2",
            date = Date(System.currentTimeMillis()),
            description = "Amazon shopping",
            emitter = "AMAZON Inc."
        ),
        Transaction(
            id = "3",
            date = Date(System.currentTimeMillis()),
            description = "Amazon shopping",
            emitter = "AMAZON Inc."
        ),
    )