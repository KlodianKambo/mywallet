package kambo.klodian.presentation.transactions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kambo.klodian.transaction.presentation.R
import kambo.klodian.transaction.presentation.databinding.FragmentTransactionsBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TransactionsFragment : Fragment(R.layout.fragment_transactions) {
    private val viewModel: TransactionsViewModel by viewModels()
    private var _binding: FragmentTransactionsBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.

    private val binding get() = _binding!!

    private val transactionAdapter = TransactionAdapter {
        viewModel.transactionSelected(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTransactionsBinding.bind(view)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = transactionAdapter

        lifecycleScope.launch {
            viewModel
                .transactionsFlow
                .flowWithLifecycle(lifecycle)
                .collectLatest {
                    transactionAdapter.submitList(it)
                }
        }

        viewModel.fetchTransactions()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}