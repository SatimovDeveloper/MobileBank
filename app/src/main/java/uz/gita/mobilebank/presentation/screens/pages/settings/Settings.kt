package uz.gita.mobilebank.presentation.screens.pages.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.gita.mobilebank.ui.theme.TextColorBlack
import uz.gita.mobilebank.ui.theme.White

object Settings:Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Settings"
            val icon = rememberVectorPainter(image = Icons.Default.Settings)
return remember{
    TabOptions(
        index = 3u,
        title = title,
        icon = icon
    )
}
        }
    @Composable
    override fun Content() {
        SettingsContent()
    }
}

@Composable
private fun SettingsContent () {
    Column(
        Modifier
            .fillMaxSize()
            .background(White)) {
        Text(text = "Settings page", fontSize = 30.sp, color = TextColorBlack)
    }

}

@Preview(showBackground = true)
@Composable
private fun PrevSettingsContent() {
    SettingsContent()

}