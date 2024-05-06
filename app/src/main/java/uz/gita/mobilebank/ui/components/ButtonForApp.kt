package uz.gita.mobilebank.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.mobilebank.R
import uz.gita.mobilebank.ui.theme.ButtonColor
import uz.gita.mobilebank.ui.theme.White

@Composable
fun ButtonGeneral(
    modifier: Modifier = Modifier,
    contentText: String,
    onClicked:(()->Unit),
    isLoading: Boolean ,
    enabled: Boolean = false
) {
    Button(
        onClick = onClicked,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonColor,
            contentColor = White,
            disabledContainerColor = ButtonColor.copy(alpha = 0.4f),
            disabledContentColor = White.copy(alpha = 0.4f)
        ),
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        content = {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp),
                    color = White,
                    strokeWidth = 2.dp
                )

            } else {
                Text(
                    text = contentText,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(600)
                    )
                )
            }
        }
    )

}

@Preview
@Composable
private fun ButtonGeneralPreview() {
    ButtonGeneral(contentText = "Next", isLoading = false,onClicked = {})
}