package kambo.klodian.data

import kambo.klodian.domain.Transaction
import kambo.klodian.domain.datasource.RemoteTransactionDataSource
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