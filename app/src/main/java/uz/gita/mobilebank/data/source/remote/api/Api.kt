package uz.gita.mobilebank.data.source.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.mobilebank.data.source.remote.request.auth.SignUpRequest
import uz.gita.mobilebank.data.source.remote.response.auth.SignUpResponse

interface Api {

    @POST("mobile-bank/v1/auth/sign-up")
    suspend fun signUp(@Body signUpRequest: SignUpRequest):Response<SignUpResponse>

}