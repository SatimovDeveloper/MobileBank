package uz.gita.mobilebank.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.mobilebank.data.source.local.Pref
import uz.gita.mobilebank.utils.myLog
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val direction: SplashContract.Direction,
    private val sharedPref: Pref
) : SplashContract.ViewModel, ViewModel() {
    override fun openIntroScreen() {
        "Intro Screen ochilyapti".myLog()
        viewModelScope.launch {
            delay(1500)
            if (sharedPref.isShowIntro()) {
                direction.openLoginScreen()
            } else {
                direction.openIntroScreen()
            }
        }
    }

    override val container =
        container<SplashContract.UiState, SplashContract.SideEffect>(SplashContract.UiState.InitState)

}