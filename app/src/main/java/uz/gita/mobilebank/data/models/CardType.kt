package uz.gita.mobilebank.data.models

import androidx.annotation.DrawableRes

data class CardType(
    val type:CardTypeEnum,
    @DrawableRes val imageRes:Int,
    val cardName:String
)
