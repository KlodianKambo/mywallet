package kambo.klodian.presentation.model

data class UiTransaction(
    val id: String,
    val formattedDate: String,
    val description: String,
    val emitter: String
)