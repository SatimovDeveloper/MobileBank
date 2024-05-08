package uz.gita.mobilebank.presentation.screens.auth.signIn

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject
@HiltViewModel
class SignInModelImp @Inject constructor(
    private val direction: SignInContract.Direction
) : SignInContract.ViewModel, ViewModel() {
    override fun onEventDispatcher(intent: SignInContract.Intent)  = intent{
        when(intent){
            is SignInContract.Intent.ClickSignUp ->{
                direction.signInToSignUp()
            }
            is SignInContract.Intent.ClickSignIn ->{

            }
        }
    }

    override val container =
        container<SignInContract.UiState, SignInContract.SideEffect>(SignInContract.UiState.InitState)
}