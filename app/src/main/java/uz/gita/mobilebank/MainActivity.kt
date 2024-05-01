package uz.gita.mobilebank

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.mobilebank.presentation.screens.signIn.SignIn
import uz.gita.mobilebank.presentation.screens.signUp.SignUp
import uz.gita.mobilebank.presentation.screens.splash.SplashScreen
import uz.gita.mobilebank.ui.theme.MobileBankTheme
import uz.gita.mobilebank.utils.navigation.NavigationHandler
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankTheme {
                Navigator(screen = SignUp()) { navigator ->
                    navigationHandler.navigationStack
                        .onEach { it.invoke(navigator) }
                        .launchIn(lifecycleScope)
                    CurrentScreen()
                }

            }
        }
    }
}

