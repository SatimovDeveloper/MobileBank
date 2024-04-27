package uz.gita.mobilebank.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey

class Test : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        TestContent()
    }
}

@Composable
fun TestContent() {

}

@Preview
@Composable
private fun TestPreview() {

}