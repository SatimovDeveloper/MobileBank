package uz.gita.mobilebank.presentation.screens.verifySignUp

import uz.gita.mobilebank.presentation.screens.pinCode.PinScreen
import uz.gita.mobilebank.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VerifyDirection @Inject constructor(
    private val navigator: AppNavigator
):VerifySignUpContract.Direction {
    override suspend fun verifySignUpToSignup() {
        navigator.back()
    }

    override suspend fun verifySignUpToPinScreen() {
        navigator.navigateTo(PinScreen())
    }
}