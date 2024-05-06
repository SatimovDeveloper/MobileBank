package uz.gita.mobilebank.presentation.screens.signIn

import uz.gita.mobilebank.presentation.screens.signUp.SignUpScreen
import uz.gita.mobilebank.utils.navigation.AppNavigator
import javax.inject.Inject
class SignInDirectionImp @Inject constructor(
private val   navigator: AppNavigator

):SignInContract.Direction{
    override suspend fun signInToSignUp() {
        navigator.navigateTo(SignUpScreen())
    }
}