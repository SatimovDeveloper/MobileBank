package uz.gita.mobilebank.domain.auth

import kotlinx.coroutines.flow.Flow
import uz.gita.mobilebank.data.source.remote.request.auth.SignUpRequest

interface AuthRepository {
 fun signUp(data:SignUpRequest):Flow<Result<Boolean>>
 fun verifySignUp(code:String):Flow<Result<Unit>>
 fun resendSignUp():Flow<Result<Unit>>



}