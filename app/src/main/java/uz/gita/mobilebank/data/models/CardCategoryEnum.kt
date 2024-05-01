package uz.gita.mobilebank.data.models

import androidx.annotation.DrawableRes
import uz.gita.mobilebank.R

enum class CardCategoryEnum( @DrawableRes img:Int,  name:String) {

    MASTERCARD(R.drawable.ic_maaster_card,"Master card"),
    UZCARD(R.drawable.ic_maaster_card,"UzCard"),
    VISA(R.drawable.ic_maaster_card,"Visa"),
    HUMO(R.drawable.ic_maaster_card,"Humo")



}