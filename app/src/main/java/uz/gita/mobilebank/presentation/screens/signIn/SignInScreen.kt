package uz.gita.mobilebank.presentation.screens.signIn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.mobilebank.R
import uz.gita.mobilebank.ui.components.ButtonGeneral
import uz.gita.mobilebank.ui.components.PhoneMaskTransformation
import uz.gita.mobilebank.ui.components.TopAppBarWithNavigation
import uz.gita.mobilebank.ui.theme.TextColorBlack
import uz.gita.mobilebank.ui.theme.TextColorBlue
import uz.gita.mobilebank.ui.theme.TextColorDarkGray
import uz.gita.mobilebank.ui.theme.TextColorGray
import uz.gita.mobilebank.utils.myLog

class SignInScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: SignInContract.ViewModel = getViewModel<SignInModelImp>()
        ScreenContent(
            uiState = viewModel.collectAsState().value,
            onEventDispatcher = viewModel::onEventDispatcher
        )
    }
}

@Composable
private fun ScreenContent(
    uiState: SignInContract.UiState,
    onEventDispatcher: (SignInContract.Intent) -> Unit
) {
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(value = false) }
    val focusManager = LocalFocusManager.current

    when (uiState) {
        is SignInContract.UiState.InitState -> {
            Scaffold(
                topBar = { TopAppBarWithNavigation(onClick = {}) }

            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(start = 24.dp, end = 24.dp, top = 36.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_in),
                        style = TextStyle(
                            fontSize = 32.sp,
                            color = TextColorBlack,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(id = R.string.phone),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = TextColorDarkGray
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = "Email"
                            )
                        },
                        value = phoneNumber,
                        onValueChange = {
                            if (it.length <= 9) {
                                phoneNumber = it
                            }else{
                                focusManager.clearFocus()

                            }

                            "$phoneNumber".myLog()
                        },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        prefix = {
                            Text("+998")
                        },
                        visualTransformation = PhoneMaskTransformation

                    )

                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(id = R.string.password),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = TextColorDarkGray
                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_password),
                                contentDescription = "Email"
                            )
                        },
                        value = password,
                        onValueChange = { password = it },
                        visualTransformation = if (showPassword) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        trailingIcon = {
                            if (showPassword) {
                                IconButton(onClick = { showPassword = false }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_password_show),
                                        contentDescription = null
                                    )
                                }
                            } else {
                                IconButton(onClick = { showPassword = true }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_password_hide),
                                        contentDescription = null
                                    )
                                }
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                    ButtonGeneral(
                        modifier = Modifier
                            .padding(top = 36.dp)
                            .fillMaxWidth()
                            .height(56.dp),
                        contentText = stringResource(id = R.string.sign_in),
                        onClicked = {}
                    )
                    Row(
                        modifier = Modifier.padding(top = 12.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = stringResource(id = R.string.go_to_sign_up),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = TextColorGray
                            )
                        )
                        Text(
                            modifier = Modifier.clickable {
                                onEventDispatcher(SignInContract.Intent.ClickSignUp)
                            },
                            text = stringResource(id = R.string.sign_up),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = TextColorBlue
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun ScreenPreView() {
    ScreenContent(uiState = SignInContract.UiState.InitState, {})
}