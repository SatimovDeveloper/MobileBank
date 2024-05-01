package uz.gita.mobilebank.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class IntroUiData(
    @DrawableRes val imgRes: Int,
    @StringRes val textTitle: Int,
    @StringRes val text: Int
)
