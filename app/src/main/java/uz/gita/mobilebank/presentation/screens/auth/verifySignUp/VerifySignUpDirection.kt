package uz.gita.mobilebank.presentation.screens.auth.verifySignUp

import uz.gita.mobilebank.presentation.screens.main.MainScreen
import uz.gita.mobilebank.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VerifySignUpDirection @Inject constructor(
    private val navigator: AppNavigator
): VerifySignUpContract.Direction {
    override suspend fun verifySignUpToSignup() {
        navigator.back()
    }

    override suspend fun verifySignUpToMainScreen() {
        navigator.navigateTo(MainScreen())
    }
}