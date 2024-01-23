package kambo.klodian.transactiondetails.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kambo.klodian.transactiondetails.presentation.databinding.FragmentTransactionDetailBinding

@AndroidEntryPoint
class TransactionDetailFragment: Fragment(R.layout.fragment_transaction_detail) {
    private val viewModel: TransactionDetailViewModel by viewModels()
    private var _binding: FragmentTransactionDetailBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTransactionDetailBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}