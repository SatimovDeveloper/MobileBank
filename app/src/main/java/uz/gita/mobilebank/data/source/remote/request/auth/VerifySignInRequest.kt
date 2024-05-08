package uz.gita.mobilebank.data.source.remote.request.auth

data class VerifySignInRequest (
    val token:String,
    val code:String
)