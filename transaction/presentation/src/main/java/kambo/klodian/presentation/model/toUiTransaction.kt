package kambo.klodian.presentation.model

import kambo.klodian.domain.Transaction
import kambo.klodian.presentation.transactiondetail.UiTransactionDetailScreen

internal fun Transaction.toUiTransaction(formattedDate: String): UiTransaction {
        return UiTransaction(
            id = id,
            formattedDate = formattedDate,
            description = description,
            emitter = emitter
        )
    }

internal fun Transaction.toUiTransactionDetail(formattedDate: String): UiTransactionDetailScreen.UiTransactionDetail {
        return UiTransactionDetailScreen.UiTransactionDetail(
            id = id,
            formattedDate = formattedDate,
            description = description,
            emitter = emitter
        )
    }