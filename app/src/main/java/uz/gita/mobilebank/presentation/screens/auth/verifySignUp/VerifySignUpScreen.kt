package uz.gita.mobilebank.presentation.screens.auth.verifySignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.hilt.getViewModel
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.mobilebank.R
import uz.gita.mobilebank.ui.components.ButtonGeneral
import uz.gita.mobilebank.ui.theme.LightGray
import uz.gita.mobilebank.ui.theme.TextColorBlack
import uz.gita.mobilebank.ui.theme.White

class VerifySignUpScreen(val phone: String) : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: VerifySignUpContract.ViewModel = getViewModel<VerifySignUpModel>()
        viewModel.onEventDispatcher(VerifySignUpContract.Intent.LoadPhoneIntent(phone))
        val uiState = viewModel.collectAsState().value
        ScreenContent(uiState, viewModel::onEventDispatcher)
    }
}

@Composable
private fun ScreenContent(
    uiState: VerifySignUpContract.UiState,
    onEventDispatcher: (VerifySignUpContract.Intent) -> Unit
) {
    var timerState by remember { mutableStateOf(true) }
    var buttonState by remember { mutableStateOf(false) }
    var timer by remember { mutableStateOf(59) }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var smsCode by remember { mutableStateOf("") }
    var launchedKey = true
    LaunchedEffect(key1 = launchedKey) {
        while (timer > 0) {
            delay(1000)
            timer--
            if (timer == 0) timerState = false
        }
    }

    when (uiState) {
        is VerifySignUpContract.UiState.InitState -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Scaffold(
                    Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .background(White),
                            contentPadding = AppBarDefaults.ContentPadding,
                            backgroundColor = White,
                            elevation = 0.dp
                        ) {

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = White)
                            ) {
                                IconButton(
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp, vertical = 8.dp)
                                        .size(40.dp)
                                        .background(color = LightGray, shape = CircleShape)
                                        .padding(8.dp)
                                        .align(Alignment.CenterStart),
                                    onClick = { onEventDispatcher(VerifySignUpContract.Intent.ClickBackButton) }) {
                                    Icon(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        imageVector = Icons.Rounded.KeyboardArrowLeft,
                                        contentDescription = null,
                                    )
                                }
                                Text(
                                    modifier = Modifier.align(Alignment.Center),
                                    text = stringResource(R.string.verify_code),
                                    style = TextStyle(
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = TextColorBlack
                                    )
                                )
                            }
                        }
                    },
                    content = { contentPadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(contentPadding)
                        ) {
                            Spacer(modifier = Modifier.height(24.dp))
                            Card(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                shape = RoundedCornerShape(12.dp),
                                elevation = CardDefaults.cardElevation(1.dp),
                                colors = CardDefaults.cardColors(containerColor = LightGray)
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        horizontal = 8.dp,
                                        vertical = 12.dp
                                    ),
                                    text = "${context.getString(R.string.content_text)} ${uiState.verifyText}",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.inter)),
                                        fontWeight = FontWeight(400),
                                        letterSpacing = TextUnit(0.5f, TextUnitType.Sp),
                                        color = TextColorBlack,
                                        textAlign = TextAlign.Justify
                                    )
                                )
                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp, vertical = 4.dp)
                                        .padding(bottom = 16.dp)
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                ) {
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .weight(1f)
                                            .wrapContentHeight(),
                                        shape = RoundedCornerShape(8.dp),
                                        maxLines = 1,
                                        singleLine = true,
                                        value = smsCode,
                                        onValueChange = {
                                            if (it.length <= 6) {
                                                smsCode = it
                                                buttonState = smsCode.length >= 6
                                            } else {
                                                buttonState = true
                                                focusManager.clearFocus()
                                            }
                                        },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Number,
                                            imeAction = ImeAction.Go

                                        ),
                                        keyboardActions = KeyboardActions(onGo = {
                                            focusManager.clearFocus()
                                        })
                                    )
                                    Box(
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                            .size(56.dp)
                                            .border(
                                                width = 1.dp,
                                                color = TextColorBlack.copy(alpha = 0.7f),
                                                shape = RoundedCornerShape(8.dp)
                                            ),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        if (timerState) {
                                            Text(
                                                modifier = Modifier
                                                    .wrapContentWidth()
                                                    .wrapContentHeight(),
                                                text = "00:$timer",
                                                textAlign = TextAlign.Center,
                                                style = TextStyle(
                                                    fontSize = 14.sp,

                                                    ),
                                            )
                                        } else {
                                            IconButton(
                                                modifier = Modifier.fillMaxSize(),
                                                onClick = {
                                                    timerState = true
                                                    timer = 59
                                                    smsCode = ""
                                                    launchedKey = false

                                                    onEventDispatcher(VerifySignUpContract.Intent.ClickRefreshCode)
                                                }
                                            ) {
                                                Icon(
                                                    modifier = Modifier
                                                        .padding(8.dp)
                                                        .fillMaxSize(),
                                                    imageVector = Icons.Default.Refresh,
                                                    contentDescription = null
                                                )

                                            }
                                        }


                                    }
                                }


                            }

                            ButtonGeneral(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 64.dp)
                                    .fillMaxWidth()
                                    .height(56.dp),
                                contentText = context.getString(R.string.verification),
                                onClicked = {
                                    onEventDispatcher(
                                        VerifySignUpContract.Intent.ClickNextButton(
                                            smsCode
                                        )
                                    )
                                },
                                enabled = buttonState,
                                isLoading = false
                            )
                        }
                    }
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun PreviewScreen() {
    ScreenContent(VerifySignUpContract.UiState.InitState(), {})
}