package uz.gita.mobilebank.data.source.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.mobilebank.data.source.remote.request.auth.ResendSignUpRequest
import uz.gita.mobilebank.data.source.remote.request.auth.SignUpRequest
import uz.gita.mobilebank.data.source.remote.request.auth.VerifySignUpRequest
import uz.gita.mobilebank.data.source.remote.response.auth.ResendSignUpResponse
import uz.gita.mobilebank.data.source.remote.response.auth.SignUpResponse
import uz.gita.mobilebank.data.source.remote.response.auth.VerifySignUpResponse

interface Api {

    @POST("mobile-bank/v1/auth/sign-up")
    suspend fun signUp(@Body signUpRequest: SignUpRequest):Response<SignUpResponse>
    @POST("mobile-bank/v1/auth/sign-up/verify")
    suspend fun verifySignUp(@Body verifyData:VerifySignUpRequest):Response<VerifySignUpResponse>
    @POST("mobile-bank/v1/auth/sign-up/resend")
    suspend fun resendSignUp(@Body resendData:ResendSignUpRequest):Response<ResendSignUpResponse>




}