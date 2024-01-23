package kambo.klodian.domain

import java.util.Date

data class Transaction(
    val id: String,
    val date: Date,
    val description: String,
    val emitter: String
)
