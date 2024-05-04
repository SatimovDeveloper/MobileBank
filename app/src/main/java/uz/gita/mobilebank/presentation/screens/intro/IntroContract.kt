package uz.gita.mobilebank.presentation.screens.intro

import org.orbitmvi.orbit.ContainerHost

interface IntroContract {
    interface IntroViewModel : ContainerHost<UiState, SideEffect> {
        fun onEventDispatcher(intent: Intent)
    }

    sealed interface Intent {
        data object ClickNext:Intent
    }

    interface UiState {
        data object InitState : UiState
    }

    sealed interface SideEffect {

    }
}