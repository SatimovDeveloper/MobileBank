package uz.gita.mobilebank.presentation.screens.auth.signIn

import org.orbitmvi.orbit.ContainerHost
import uz.gita.mobilebank.data.source.remote.request.auth.SignInRequest

interface SignInContract {

    interface ViewModel :ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: Intent)

    }

    sealed interface UiState{
        data object InitState: UiState

    }

    sealed interface Intent{
        data object ClickSignUp: Intent
        data class ClickSignIn(val data:SignInRequest):Intent

    }

    sealed interface SideEffect{

    }
    interface Direction {
        suspend fun signInToSignUp()


    }

}