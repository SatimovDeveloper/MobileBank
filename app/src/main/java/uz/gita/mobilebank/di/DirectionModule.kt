package uz.gita.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebank.presentation.screens.intro.IntroDirection
import uz.gita.mobilebank.presentation.screens.intro.IntroDirectionImp
import uz.gita.mobilebank.presentation.screens.splash.SplashContract
import uz.gita.mobilebank.presentation.screens.splash.SplashDirection
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
    @Binds
    fun splashDirection(direction:SplashDirection):SplashContract.Direction

    @Binds
    fun introDirection(direction:IntroDirectionImp):IntroDirection
}