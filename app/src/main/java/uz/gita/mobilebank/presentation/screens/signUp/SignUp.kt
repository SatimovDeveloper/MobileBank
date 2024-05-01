package uz.gita.mobilebank.presentation.screens.signUp

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
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
import uz.gita.mobilebank.R
import uz.gita.mobilebank.ui.theme.MobileBankTheme
import uz.gita.mobilebank.ui.theme.TextColorBlack
import uz.gita.mobilebank.ui.theme.TextColorBlue
import uz.gita.mobilebank.ui.theme.TextColorDarkGray
import uz.gita.mobilebank.ui.theme.TextColorGray
import uz.gita.mobilebank.utils.widgets.ButtonGeneral
import uz.gita.mobilebank.utils.widgets.TopAppBarWithNavigation

class SignUp : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        MobileBankTheme {
            ScreenContent()
        }

    }

}

@Composable
private fun ScreenContent() {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var bornDate by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBarWithNavigation {

        }
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 28.dp),
                text = stringResource(id = R.string.sign_up),
                style = TextStyle(
                    fontSize = 32.sp,
                    color = TextColorBlack,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontWeight = FontWeight(500)
                )
            )
            Text(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 8.dp),
                text = stringResource(id = R.string.first_name),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(400),
                    color = TextColorDarkGray
                )
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 4.dp)
                    .fillMaxWidth(),
                value = firstName,
                onValueChange = { firstName = it },
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Text(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 12.dp),
                text = stringResource(id = R.string.last_name),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(400),
                    color = TextColorDarkGray
                )
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 4.dp)
                    .fillMaxWidth(),
                value = lastName,
                onValueChange = { lastName = it },
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 12.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(id = R.string.born_date),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = TextColorDarkGray
                        )
                    )
                    OutlinedTextField(
                        value = bornDate,
                        onValueChange = { bornDate = it },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(id = R.string.gender),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = TextColorDarkGray
                        )
                    )
                    OutlinedTextField(
                        value = gender,
                        onValueChange = { gender = it },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                }
            }

            Text(
                modifier = Modifier.padding(start = 24.dp, top = 0.dp),
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
                    .padding(start = 24.dp, end = 24.dp, top = 4.dp)
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "phone",
                        tint = TextColorGray
                    )
                },
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)

            )

            Text(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 12.dp),
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
                    .padding(start = 24.dp, end = 24.dp, top = 4.dp)
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

            Text(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 12.dp),
                text = stringResource(id = R.string.confirm_password),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(400),
                    color = TextColorDarkGray
                )
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 4.dp)
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_password),
                        contentDescription = "Email"
                    )
                },
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                visualTransformation = if (showConfirmPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    if (showConfirmPassword) {
                        IconButton(onClick = { showConfirmPassword = false }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_password_show),
                                contentDescription = null
                            )
                        }
                    } else {
                        IconButton(onClick = { showConfirmPassword = true }) {
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
                    .padding(start = 24.dp, end = 24.dp, top = 24.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                contentText = stringResource(id = R.string.sign_up)
            ) {

            }

            Row(
                modifier = Modifier.padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(id = R.string.go_to_sign_in),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = TextColorGray
                    )
                )
                Text(
                    text = stringResource(id = R.string.sign_in),
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

@Composable
private fun InputName(
    modifier: Modifier = Modifier, @StringRes labelText: Int, value: String

) {
    Column(modifier = modifier) {


    }

}

@Preview
@Composable
private fun ScreenPrev() {
    ScreenContent()
}