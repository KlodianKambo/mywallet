package kambo.klodian.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kambo.klodian.home.presentation.databinding.FragmentHomeBinding

@AndroidEntryPoint
class OverviewFragment: Fragment(R.layout.fragment_home) {
    private val viewModel: OverviewViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        binding.button.setOnClickListener {
            viewModel.submitData()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}