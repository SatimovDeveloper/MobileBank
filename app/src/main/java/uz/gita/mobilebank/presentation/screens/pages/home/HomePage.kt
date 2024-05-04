package uz.gita.mobilebank.presentation.screens.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.gita.mobilebank.R
import uz.gita.mobilebank.ui.theme.MobileBankTheme
import uz.gita.mobilebank.ui.theme.White

object HomePage : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(image = Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }

        }

    @Composable
    override fun Content() {
        MobileBankTheme {
            HomeContent()
        }
    }
}

@Composable
private fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), 
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier.size(50.dp),
                shape = CircleShape
            ){
                Box(modifier = Modifier.fillMaxSize()){
                    Image(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription =null
                    )
                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun PrevHomeContent() {
    HomeContent()
}