package uz.gita.mobilebank.presentation.screens.auth.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.mobilebank.domain.auth.AuthRepository
import uz.gita.mobilebank.utils.myLog
import javax.inject.Inject

@HiltViewModel
class SignUpModelImp @Inject constructor(
    private val direction: SignUpContract.Direction,
    private val repository: AuthRepository,
) : SignUpContract.Viewmodel, ViewModel() {
    override fun onEventDispatcher(intent: SignUpContract.Intent) {
        when (intent) {
            is SignUpContract.Intent.ClickSignUp -> {
                intent {
                    reduce { SignUpContract.UiState.InitUiState(isLoading = true) }
                }

                repository.signUp(intent.data)
                    .onEach { result ->
                        result.onSuccess {
                            "SignUp model success".myLog()
                            intent {
                                reduce { SignUpContract.UiState.InitUiState(isLoading = false) }
                            }
                            direction.signUpToVerifySignUp(intent.data.phone)
                        }
                            .onFailure {
                                "Sign up Model Failure: ${it.message}".myLog()
                                intent {
                                    reduce { SignUpContract.UiState.InitUiState(false) }
                                }

                            }

                    }
                    .launchIn(viewModelScope)

            }

            SignUpContract.Intent.ClickSignIn -> {
                intent{
                    direction.signUpToSigIn()
                }
            }
            SignUpContract.Intent.ClickBackButton -> {
                intent {
                    direction.signUpToSigIn()
                }
            }
        }
    }

    override val container =
        container<SignUpContract.UiState, SignUpContract.SideEffect>(
            SignUpContract.UiState.InitUiState(
                isLoading = false
            )
        )

}