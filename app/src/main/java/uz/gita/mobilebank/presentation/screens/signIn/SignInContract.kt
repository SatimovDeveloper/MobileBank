package uz.gita.mobilebank.presentation.screens.signIn

import org.orbitmvi.orbit.ContainerHost

interface SignInContract {

    interface ViewModel :ContainerHost<UiState,SideEffect>{
        fun onEventDispatcher(intent:Intent)

    }

    sealed interface UiState{
        data object InitState:UiState

    }

    sealed interface Intent{
        data object ClickSignUp:Intent

    }

    sealed interface SideEffect{

    }
    interface SignInDirection {
        suspend fun signInToSignUp()


    }

}