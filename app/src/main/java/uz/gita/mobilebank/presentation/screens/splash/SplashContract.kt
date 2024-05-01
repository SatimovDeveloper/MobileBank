package uz.gita.mobilebank.presentation.screens.splash

import org.orbitmvi.orbit.ContainerHost

interface SplashContract {
    interface ViewModel : ContainerHost<UiState, SideEffect> {
        fun openIntroScreen()

    }

    sealed interface Intent {

    }

    sealed interface UiState {
        data object InitState : UiState
    }

    sealed interface SideEffect {

    }

    interface Direction {
        suspend fun openIntroScreen()
        suspend fun openLoginScreen()
    }
}