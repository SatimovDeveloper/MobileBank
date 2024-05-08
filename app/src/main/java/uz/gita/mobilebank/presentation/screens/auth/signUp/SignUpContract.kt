package uz.gita.mobilebank.presentation.screens.auth.signUp

import org.orbitmvi.orbit.ContainerHost
import uz.gita.mobilebank.data.source.remote.request.auth.SignUpRequest

interface SignUpContract {

    interface Viewmodel:ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: Intent)
    }

    sealed interface Intent{
        data object  ClickSignIn: Intent
        data class ClickSignUp(val data:SignUpRequest): Intent
        data object ClickBackButton: Intent
    }
    sealed interface UiState{
        data class InitUiState(val isLoading:Boolean): UiState
    }

    sealed interface SideEffect{

    }

    interface Direction{
        suspend fun signUpToVerifySignUp(phone:String)
        suspend fun signUpToSigIn()

    }


}