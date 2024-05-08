package uz.gita.mobilebank.presentation.screens.auth.verifySignUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.mobilebank.domain.auth.AuthRepository
import javax.inject.Inject

@HiltViewModel
class VerifySignUpModel @Inject constructor(
    private val repository: AuthRepository,
    private val direction: VerifySignUpContract.Direction,
) : VerifySignUpContract.ViewModel, ViewModel() {
    init {
        //init()
    }

    override fun onEventDispatcher(intent: VerifySignUpContract.Intent) = intent {
        when (intent) {
            is VerifySignUpContract.Intent.ClickRefreshCode -> {
                repository.resendSignUp()
                    .onEach {result ->
                        result.onSuccess {}
                            .onFailure {}
                    }
                    .launchIn(viewModelScope)
            }

            is VerifySignUpContract.Intent.ClickNextButton -> {
                repository.verifySignUp(intent.code)
                    .onEach { result ->
                        result.onSuccess {
                            direction.verifySignUpToMainScreen()
                        }
                            .onFailure {
                            }
                    }
                    .launchIn(viewModelScope)

            }

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