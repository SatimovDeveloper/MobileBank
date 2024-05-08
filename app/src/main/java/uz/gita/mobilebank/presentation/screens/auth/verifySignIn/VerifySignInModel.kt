package uz.gita.mobilebank.presentation.screens.auth.verifySignIn

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.mobilebank.domain.auth.AuthRepository
import javax.inject.Inject

@HiltViewModel
class VerifySignInModel @Inject constructor(
    private val direction: VerifySignInContract.Direction,
    val repository: AuthRepository
) : VerifySignInContract.ViewModel, ViewModel() {
    override fun onEventDispatcher(intent: VerifySignInContract.Intent)  = intent{
        when(intent){
            is VerifySignInContract.Intent.ClickBackButton ->{

            }
            is VerifySignInContract.Intent.ClickRefreshCode ->{

            }
            is VerifySignInContract.Intent.LoadPhoneIntent ->{

            }
            is VerifySignInContract.Intent.ClickNextButton -> {

            }
        }
    }

    override val container =
        container<VerifySignInContract.UiState, VerifySignInContract.SideEffect>(
            VerifySignInContract.UiState.InitState()
        )
}