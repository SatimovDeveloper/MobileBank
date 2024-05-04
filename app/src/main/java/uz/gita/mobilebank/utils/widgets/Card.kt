package uz.gita.mobilebank.utils.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.mobilebank.R
import uz.gita.mobilebank.data.models.CardType
import uz.gita.mobilebank.data.models.CardTypeEnum
import uz.gita.mobilebank.data.models.CardUiData
import uz.gita.mobilebank.ui.theme.CardBackgroundColor
import uz.gita.mobilebank.ui.theme.CardBorderColor
import uz.gita.mobilebank.ui.theme.CardNfcColor
import uz.gita.mobilebank.ui.theme.TextColorDarkGray
import uz.gita.mobilebank.ui.theme.White
import uz.gita.mobilebank.utils.getCardNumberForUi

@Composable
fun Card(
    modifier: Modifier = Modifier,
    data: CardUiData
) {
    val cardNumber = data.cardNumber.getCardNumberForUi()
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(CardBackgroundColor),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, CardBorderColor)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.ic_card_image),
                    contentDescription = "imageCard",
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 16.dp, top = 24.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_card_e_sim),
                        contentDescription = "cardESim"
                    )
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_card_nfc),
                        contentDescription = "cardESim",
                        tint = CardNfcColor
                    )
                }

                Text(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 16.dp, top = 16.dp)
                        .fillMaxWidth(),
                    text = cardNumber,
                    style = TextStyle(
                        color = White,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.inter))
                    )
                )

                Text(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 16.dp, top = 8.dp)
                        .fillMaxWidth(),
                    text = data.cardName,
                    style = TextStyle(
                        color = White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.inter))
                    )
                )

                Row(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = stringResource(id = R.string.valid_data),
                            style = TextStyle(
                                color = TextColorDarkGray,
                                fontSize = 9.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = FontFamily(Font(R.font.inter))
                            )

                        )
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = data.validDate,
                            style = TextStyle(
                                color = White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = FontFamily(Font(R.font.inter))
                            )

                        )

                    }
                    Spacer(modifier = Modifier.weight(1f))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = stringResource(id = R.string.svv),
                            style = TextStyle(
                                color = TextColorDarkGray,
                                fontSize = 9.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = FontFamily(Font(R.font.inter))
                            )

                        )
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = data.cVVCode,
                            style = TextStyle(
                                color = White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = FontFamily(Font(R.font.inter))
                            )
                        )
                    }
                    Spacer(modifier = Modifier.weight(3f))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                       Image(
                           modifier = Modifier.size(24.dp),
                           painter = painterResource(id = data.cardCategory.imageRes),
                           contentDescription = "imgCard",
                           contentScale = ContentScale.Crop
                       )
                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            text = data.cardCategory.cardName ,
                            style = TextStyle(
                                color = White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = FontFamily(Font(R.font.inter))
                            )
                        )
                    }

                }
            }


        }


    }


}

@Preview(showBackground = true)
@Composable
private fun PreviewCard() {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(200.dp),
        data = CardUiData(
            cardNumber = "1234567890123456",
            cardName = "Satimov Dilshodbek",
            validDate = "02/05",
            cVVCode = "586",
            cardCategory = CardType(
                CardTypeEnum.UZCARD,
                R.drawable.ic_uz_card,
                CardTypeEnum.UZCARD.nameCard
            )
        )
    )

}