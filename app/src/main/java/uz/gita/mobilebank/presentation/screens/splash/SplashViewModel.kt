package uz.gita.mobilebank.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val direction: SplashContract.Direction
) : SplashContract.ViewModel, ViewModel() {
    override fun openIntroScreen() {
        viewModelScope.launch {
            delay(1500)
            direction.openIntroScreen()
        }
    }

    override val container =
        container<SplashContract.UiState, SplashContract.SideEffect>(SplashContract.UiState.InitState)

}