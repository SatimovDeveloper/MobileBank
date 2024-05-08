package uz.gita.mobilebank.data.source.remote.response.auth

import com.google.gson.annotations.SerializedName

data class VerifySignInResponse(
    @SerializedName("refresh-token")
    val refreshToken:String,
    @SerializedName("access-token")
    val accessToken:String
)
