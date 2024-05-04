package uz.gita.mobilebank.presentation.screens.intro

import android.accessibilityservice.AccessibilityService.ScreenshotResult
import cafe.adriel.voyager.core.screen.Screen
import uz.gita.mobilebank.utils.navigation.AppNavigator
import javax.inject.Inject

interface IntroDirection {
    suspend fun navigate(screen:Screen)
}

class IntroDirectionImp @Inject constructor(
    private val navigator: AppNavigator
):IntroDirection{
    override suspend fun navigate(screen: Screen) {
        navigator.replace(screen)
    }

}