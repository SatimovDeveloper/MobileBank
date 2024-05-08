package uz.gita.mobilebank.presentation.screens.splash

import uz.gita.mobilebank.presentation.screens.intro.IntroScreen
import uz.gita.mobilebank.presentation.screens.auth.signIn.SignInScreen
import uz.gita.mobilebank.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SplashDirection @Inject constructor(
    private val navigator:AppNavigator
):SplashContract.Direction {
    override suspend fun openIntroScreen() {
        navigator.replace(IntroScreen())
    }

    override suspend fun openLoginScreen() {
       navigator.replace(SignInScreen())
    }
}