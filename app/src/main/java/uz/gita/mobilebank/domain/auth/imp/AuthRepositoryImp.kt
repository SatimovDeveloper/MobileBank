package uz.gita.mobilebank.domain.auth.imp

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.mobilebank.data.source.local.Pref
import uz.gita.mobilebank.data.source.remote.api.Api
import uz.gita.mobilebank.data.source.remote.request.auth.ResendSignUpRequest
import uz.gita.mobilebank.data.source.remote.request.auth.SignUpRequest
import uz.gita.mobilebank.data.source.remote.request.auth.VerifySignUpRequest
import uz.gita.mobilebank.data.source.remote.response.auth.ErrorResponse
import uz.gita.mobilebank.domain.auth.AuthRepository
import uz.gita.mobilebank.utils.myLog
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImp @Inject constructor(
    private val shared: Pref,
    private val gson: Gson,
    private val api: Api
) : AuthRepository {
    override fun signUp(data: SignUpRequest): Flow<Result<Boolean>> = flow {
        val signUpResponse = api.signUp(data)
        if (signUpResponse.isSuccessful && signUpResponse.body() != null) {
            emit(Result.success(true))
            shared.setPhoneNumber(data.phone)
            shared.setToken(signUpResponse.body()!!.token)
            " Auth RepositoryImpl token: ${signUpResponse.body()!!.token}".myLog()
        } else {
            val error = gson.fromJson(
                signUpResponse.errorBody()?.string(),
                ErrorResponse::class.java
            )
            " Auth RepositoryImpl Sign Up error: ${error.message}".myLog()
            emit(Result.failure(Throwable(error.message)))
        }

//            when (signUpResponse.code()) {
//                in 200 until 300 -> {
//                    emit(Result.success(true))
//                    " Auth RepositoryImpl token: ${signUpResponse.body()!!.token}".myLog()
//                }
//                in 300 until 400 -> {
//                    emit(Result.failure(Throwable("Unknown Error")))
//                }
//                in 400 until 500 -> {
//                    val error = gson.fromJson(
//                        signUpResponse.errorBody()?.string(),
//                        ErrorResponse::class.java
//                    )
//                    emit(Result.failure(Throwable(error.message)))
//                }
//                else -> {
//                    emit(Result.failure(Throwable("Unknown error")))
//                }
//            }
//        } else {
//            emit(Result.failure(Throwable("Response body null")))
//        }
    }.flowOn(Dispatchers.IO)

    override fun verifySignUp(code: String): Flow<Result<Unit>> = flow {
        val token = shared.getToken()
        "Auth Repository verify SignUp $token $code".myLog()
        val verifyData = VerifySignUpRequest(token = token, code = code)
        val verifyResponse = api.verifySignUp(verifyData)
        if (verifyResponse.isSuccessful && verifyResponse.body() != null) {
            emit(Result.success(Unit))
            "AuthRepository  verifySign Up ${verifyResponse.body()!!.refreshToken} ${verifyResponse.body()!!.accessToken}"
            shared.setRefreshToken(verifyResponse.body()!!.refreshToken)
            shared.setAccessToken(verifyResponse.body()!!.accessToken)
        } else {
            val error =
                gson.fromJson(verifyResponse.errorBody()?.string(), ErrorResponse::class.java)
            "Auth Repository verify SignUp ${error.message}".myLog()
            emit(Result.failure(Throwable(error.message)))
        }
    }.flowOn(Dispatchers.IO)

    override fun resendSignUp(): Flow<Result<Unit>> = flow {
        val resendSignUpData = ResendSignUpRequest(token = shared.getToken())
        "AuthRepository resendSignUp requestToken: ${resendSignUpData.token}".myLog()
        val resendSignUpResponse = api.resendSignUp(resendSignUpData)

        if (resendSignUpResponse.isSuccessful && resendSignUpResponse.body() != null) {
            emit(Result.success(Unit))
            "AuthRepository resendSignUp newToken: ${resendSignUpResponse.body()!!.token}".myLog()
            shared.setToken(resendSignUpResponse.body()!!.token)
        } else {
            val error =
                gson.fromJson(resendSignUpResponse.errorBody()?.string(), ErrorResponse::class.java)
            emit(Result.failure(Throwable(error.message)))
            "AuthRepository resendSignUp errorMessage: ${error.message}".myLog()
        }


    }

}