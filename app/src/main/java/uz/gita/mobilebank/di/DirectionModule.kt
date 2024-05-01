package uz.gita.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebank.presentation.screens.splash.SplashContract
import uz.gita.mobilebank.presentation.screens.splash.SplashDirection
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
    @Binds
    fun introDirection(direction:SplashDirection):SplashContract.Direction
}