package uz.gita.mobilebank.data.source.remote.request.auth

data class VerifySignUpRequest(
    val token:String,
    val code:String
)
