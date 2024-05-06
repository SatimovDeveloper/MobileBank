package uz.gita.mobilebank.domain.auth.imp

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.mobilebank.data.source.local.Pref
import uz.gita.mobilebank.data.source.remote.api.Api
import uz.gita.mobilebank.data.source.remote.request.auth.SignUpRequest
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

}