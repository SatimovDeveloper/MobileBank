package uz.gita.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebank.presentation.screens.intro.IntroDirection
import uz.gita.mobilebank.presentation.screens.intro.IntroDirectionImp
import uz.gita.mobilebank.presentation.screens.auth.signIn.SignInContract
import uz.gita.mobilebank.presentation.screens.auth.signIn.SignInDirectionImp
import uz.gita.mobilebank.presentation.screens.auth.signUp.SignUpContract
import uz.gita.mobilebank.presentation.screens.auth.signUp.SignUpDirection
import uz.gita.mobilebank.presentation.screens.auth.verifySignIn.VerifySignInContract
import uz.gita.mobilebank.presentation.screens.auth.verifySignIn.VerifySignInDirection
import uz.gita.mobilebank.presentation.screens.splash.SplashContract
import uz.gita.mobilebank.presentation.screens.splash.SplashDirection
import uz.gita.mobilebank.presentation.screens.auth.verifySignUp.VerifySignUpDirection
import uz.gita.mobilebank.presentation.screens.auth.verifySignUp.VerifySignUpContract

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
    @Binds
    fun splashDirection(direction:SplashDirection):SplashContract.Direction

    @Binds
    fun introDirection(direction:IntroDirectionImp):IntroDirection

    @Binds
    fun signInDirection(direction: SignInDirectionImp): SignInContract.Direction

    @Binds
    fun signUpDirection(direction: SignUpDirection): SignUpContract.Direction

    @Binds
    fun verifySignUpDirection(direction: VerifySignUpDirection): VerifySignUpContract.Direction

    @Binds
    fun verifySignInDirection(direction:VerifySignInDirection):VerifySignInContract.Direction
}