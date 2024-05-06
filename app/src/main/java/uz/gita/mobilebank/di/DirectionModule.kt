package uz.gita.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebank.presentation.screens.intro.IntroDirection
import uz.gita.mobilebank.presentation.screens.intro.IntroDirectionImp
import uz.gita.mobilebank.presentation.screens.signIn.SignInContract
import uz.gita.mobilebank.presentation.screens.signIn.SignInDirectionImp
import uz.gita.mobilebank.presentation.screens.signUp.SignUpContract
import uz.gita.mobilebank.presentation.screens.signUp.SignUpDirection
import uz.gita.mobilebank.presentation.screens.splash.SplashContract
import uz.gita.mobilebank.presentation.screens.splash.SplashDirection
import uz.gita.mobilebank.presentation.screens.verifySignUp.VerifyDirection
import uz.gita.mobilebank.presentation.screens.verifySignUp.VerifySignUpContract

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
    @Binds
    fun splashDirection(direction:SplashDirection):SplashContract.Direction

    @Binds
    fun introDirection(direction:IntroDirectionImp):IntroDirection

    @Binds
    fun signInDirection(direction:SignInDirectionImp):SignInContract.Direction

    @Binds
    fun signUpDirection(direction:SignUpDirection):SignUpContract.Direction

    @Binds
    fun verifySignUpDirection(direction:VerifyDirection):VerifySignUpContract.Direction
}