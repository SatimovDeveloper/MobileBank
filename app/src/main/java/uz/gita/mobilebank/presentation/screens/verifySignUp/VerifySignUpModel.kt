package uz.gita.mobilebank.presentation.screens.verifySignUp

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.mobilebank.data.source.local.Pref
import uz.gita.mobilebank.domain.auth.AuthRepository
import javax.inject.Inject

@HiltViewModel
class VerifySignUpModel @Inject constructor(
    private val repository: AuthRepository,
    private val gson: Gson,
    private val direction: VerifySignUpContract.Direction,
    private val shared: Pref
) : VerifySignUpContract.ViewModel, ViewModel() {
    init {
        //init()
    }

    override fun onEventDispatcher(intent: VerifySignUpContract.Intent) = intent {
        when (intent) {
            is VerifySignUpContract.Intent.ClickNextButton -> {}

            is VerifySignUpContract.Intent.ClickBackButton -> {
                direction.verifySignUpToSignup()
            }

            is VerifySignUpContract.Intent.LoadPhoneIntent -> {
                val text = "${
                    intent.phone.substring(
                        intent.phone.length - 4,
                        intent.phone.length - 2
                    )
                } ${intent.phone.substring(intent.phone.length - 2)}"
                reduce {
                    VerifySignUpContract.UiState.InitState(
                        verifyText = text
                    )
                }
            }


        }
    }

    override val container =
        container<VerifySignUpContract.UiState, VerifySignUpContract.SideEffect>(
            VerifySignUpContract.UiState.InitState()
        )

    private fun init() {

    }
}