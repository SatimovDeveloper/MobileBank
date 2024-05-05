package uz.gita.mobilebank.presentation.screens.intro

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.mobilebank.data.source.local.Pref
import uz.gita.mobilebank.presentation.screens.signIn.SignInScreen
import javax.inject.Inject

@HiltViewModel
class IntroViewModelImp @Inject constructor(
    private val direction: IntroDirection,
    private val shared:Pref
) : IntroContract.IntroViewModel, ViewModel() {
    override fun onEventDispatcher(intent: IntroContract.Intent) = intent{
        when(intent){
            is IntroContract.Intent.ClickNext ->{
                shared.setShowIntro()
                direction.navigate(SignInScreen())
            }
        }

    }

    override val container =
        container<IntroContract.UiState, IntroContract.SideEffect>(IntroContract.UiState.InitState)
}