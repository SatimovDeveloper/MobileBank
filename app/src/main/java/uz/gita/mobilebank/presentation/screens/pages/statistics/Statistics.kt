package uz.gita.mobilebank.presentation.screens.pages.statistics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.gita.mobilebank.R
import uz.gita.mobilebank.ui.theme.MobileBankTheme
import uz.gita.mobilebank.ui.theme.TextColorBlack

object Statistics: Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Statistics"
            val icon =
                rememberVectorPainter(image = ImageVector.vectorResource(R.drawable.ic_statistic))
            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }
    @Composable
    override fun Content() {
        MobileBankTheme {
            StatisticsContent()
        }
    }
}

@Composable
private fun StatisticsContent () {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Text(text = "Statistics Page", fontSize = 30.sp, color = TextColorBlack)
    }

}

@Preview(showBackground = true)
@Composable
private fun PrevStatisticsContent() {
    StatisticsContent()
}