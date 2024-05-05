package uz.gita.mobilebank.presentation.screens.signUp

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignUpModelImp @Inject constructor(

) : SignUpContract.Viewmodel, ViewModel() {
    override fun onEventDispatcher(intent: SignUpContract.Intent) {
        when(intent){
          is SignUpContract.Intent.ClickSignUp -> {}
            SignUpContract.Intent.ClickSignIn ->{}
        }
    }

    override val container =
        container<SignUpContract.UiState, SignUpContract.SideEffect>(SignUpContract.UiState.InitUiState(isLoading = false))

}