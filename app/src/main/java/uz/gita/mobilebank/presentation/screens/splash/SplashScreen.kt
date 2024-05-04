package uz.gita.mobilebank.presentation.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mobilebank.R
import uz.gita.mobilebank.ui.theme.TextColorBlack
class SplashScreen : Screen {

    @SuppressLint("SuspiciousIndentation")
    @Composable
    override fun Content() {
    val viewModel: SplashContract.ViewModel = getViewModel<SplashViewModel>()
        viewModel.openIntroScreen()
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.wrapContentSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_splash_screen),
                    contentDescription = "SplashScreen"
                )
                Text(
                    text = stringResource(id = R.string.splashText),
                    fontSize = 36.sp,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    ),
                    color = TextColorBlack

                )
            }

        }

    }


    @Preview(
        showBackground = true
    )
    @Composable
    private fun PreviewSplash() {
        Content()
    }

}

