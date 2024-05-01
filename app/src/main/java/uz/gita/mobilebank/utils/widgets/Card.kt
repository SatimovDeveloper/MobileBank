package uz.gita.mobilebank.utils.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.mobilebank.R
import uz.gita.mobilebank.data.models.CardCategoryEnum
import uz.gita.mobilebank.data.models.CardUiData
import uz.gita.mobilebank.ui.theme.CardBackgroundColor
import uz.gita.mobilebank.ui.theme.CardBorderColor

@Composable
fun Card(
    modifier: Modifier = Modifier,
    data: CardUiData
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(CardBackgroundColor),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, CardBorderColor)
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_card_e_sim),
                contentDescription = "cardESim"
            )

            Image(
                painter = painterResource(id = R.drawable.ic_card_e_sim),
                contentDescription = "cardESim"
            )


        }

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_card_image),
                contentDescription = "imageCard",
                contentScale = ContentScale.Crop
            )
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
            cardNumber = "1234 5678 9012 3456",
            cardName = "Satimov Dilshodbek",
            validDate = "02/05",
            cVVCode = "586",
            cardCategory = CardCategoryEnum.MASTERCARD
        )
    )

}