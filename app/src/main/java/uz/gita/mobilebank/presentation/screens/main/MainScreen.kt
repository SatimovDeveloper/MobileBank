package uz.gita.mobilebank.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import uz.gita.mobilebank.presentation.screens.pages.home.HomePage
import uz.gita.mobilebank.presentation.screens.pages.myCards.MyCards
import uz.gita.mobilebank.presentation.screens.pages.settings.Settings
import uz.gita.mobilebank.presentation.screens.pages.statistics.Statistics
import uz.gita.mobilebank.ui.theme.LightGray
import uz.gita.mobilebank.ui.theme.MobileBankTheme
import uz.gita.mobilebank.utils.TabNavigatorItem

class MainScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        MobileBankTheme {
            MainContent()
        }
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun MainContent() {
    TabNavigator(
        tab = HomePage,

        ) {
        Scaffold(
            content = {
                CurrentTab()
            },
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = LightGray,
                ) {
                    TabNavigatorItem(tab = HomePage)
                    TabNavigatorItem(tab = MyCards)
                    TabNavigatorItem(tab = Statistics)
                    TabNavigatorItem(tab = Settings)
                }
            }
        )
    }

}

@Preview
@Composable
private fun PrevMAinContent() {
    MainContent()
}