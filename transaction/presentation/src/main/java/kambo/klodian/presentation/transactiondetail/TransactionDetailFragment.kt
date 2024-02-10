package kambo.klodian.presentation.transactiondetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import kambo.klodian.transaction.presentation.R
import kambo.klodian.transaction.presentation.databinding.FragmentTransactionDetailBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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

        lifecycleScope.launch {
            viewModel.transactionDetailFlow.collect{
                when(it){
                    is UiTransactionDetailScreen.UiTransactionDetail -> {
                        _binding?.applyUiTransactionDetail(it)
                    }
                    UiTransactionDetailScreen.Empty -> _binding?.applyEmpty()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun FragmentTransactionDetailBinding.applyUiTransactionDetail(uiTransactionDetail: UiTransactionDetailScreen.UiTransactionDetail){
        textViewEmitter.text = uiTransactionDetail.emitter
        textViewDate.text = uiTransactionDetail.formattedDate
        textViewDescription.text = uiTransactionDetail.description
    }

    private fun FragmentTransactionDetailBinding.applyEmpty(){
        // todo
    }
}