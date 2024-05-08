package uz.gita.mobilebank.presentation.screens.auth.verifySignIn

import uz.gita.mobilebank.presentation.screens.main.MainScreen
import uz.gita.mobilebank.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VerifySignInDirection @Inject constructor(
    private val navigator: AppNavigator
):VerifySignInContract.Direction {
    override suspend fun verifySignInToMain() {
       navigator.replaceAll(MainScreen())
    }
    override suspend fun verifySignInToSignIn() {
       navigator.back()
    }
}