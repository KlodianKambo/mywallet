package kambo.klodian.presentation.transactions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kambo.klodian.presentation.model.UiTransaction
import kambo.klodian.transaction.presentation.R
import kambo.klodian.transaction.presentation.databinding.ItemTransactionBinding

class TransactionAdapter(private val action: (UiTransaction) -> Unit) :
    ListAdapter<UiTransaction, TransactionViewHolder>(TransactionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_transaction, parent, false)
            .let { TransactionViewHolder(ItemTransactionBinding.bind(it)) }

    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = getItem(position)
        holder.bind(transaction, action)
    }
}

class TransactionViewHolder(private val binding: ItemTransactionBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(transaction: UiTransaction, action: (UiTransaction) -> Unit) {
        with(binding) {
            root.setOnClickListener {
                action(transaction)
            }

            textViewDate.text = transaction.formattedDate
            textViewDescription.text = transaction.description
            textViewEmitter.text = transaction.emitter
        }
    }
}

private class TransactionDiffCallback : DiffUtil.ItemCallback<UiTransaction>() {
    override fun areItemsTheSame(oldItem: UiTransaction, newItem: UiTransaction): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiTransaction, newItem: UiTransaction): Boolean {
        return oldItem == newItem
    }
}