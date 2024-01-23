package kambo.klodian.home.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kambo.klodian.shareddomain.entities.AppState
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeActivity : AppCompatActivity(R.layout.activity_home){

    private val homeViewModel: HomeViewModel by viewModels()

    private val navController
        get()= findNavController(R.id.nav_host_fragment)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            homeViewModel.appState.collect(::navigateTo)
        }
    }

    private fun navigateTo(appState: AppState){
        val navId = when(appState){
            AppState.Overview -> R.id.fragment_overview
            AppState.Transactions -> R.id.fragment_transactions
        }

        navController.navigate(navId)
    }

}