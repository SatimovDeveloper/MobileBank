package uz.gita.mobilebank.presentation.screens.auth.signUp

import uz.gita.mobilebank.presentation.screens.main.MainScreen
import uz.gita.mobilebank.presentation.screens.auth.verifySignUp.VerifySignUpScreen
import uz.gita.mobilebank.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignUpDirection @Inject constructor(
    private val navigator: AppNavigator
) : SignUpContract.Direction {
    override suspend fun signUpToVerifySignUp(phone:String) {
        navigator.navigateTo(VerifySignUpScreen(phone))
    }

    override suspend fun signUpToSigIn() {
        navigator.back()
    }
}