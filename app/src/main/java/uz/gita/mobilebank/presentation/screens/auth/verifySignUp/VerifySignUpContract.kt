package uz.gita.mobilebank.presentation.screens.auth.verifySignUp

import org.orbitmvi.orbit.ContainerHost

interface VerifySignUpContract {
    interface ViewModel : ContainerHost<UiState, SideEffect> {
        fun onEventDispatcher(intent: Intent)
    }

    sealed interface Intent {
        data class LoadPhoneIntent(val phone: String): Intent
        data object ClickBackButton : Intent
        data class ClickNextButton (val code:String): Intent
        data object ClickRefreshCode: Intent
    }

    sealed interface UiState {
        data class InitState(val verifyText:String="00 00") : UiState

    }

    sealed interface SideEffect {

    }

    interface Direction {
        suspend fun verifySignUpToSignup()
        suspend fun verifySignUpToMainScreen()

    }
}