package uz.gita.mobilebank.data.models

data class CardUiData (
    val cardNumber:String,
    val cardName:String,
    val validDate:String,
    val cVVCode:String,
    val cardCategory:CardType
)