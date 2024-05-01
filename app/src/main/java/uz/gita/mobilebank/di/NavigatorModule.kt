package uz.gita.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebank.utils.navigation.AppNavigator
import uz.gita.mobilebank.utils.navigation.NavigationDispatcher
import uz.gita.mobilebank.utils.navigation.NavigationHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorModule {
    @Binds
    fun appNavigator(dispatcher: NavigationDispatcher): AppNavigator
    @Binds
    fun navigationHandler(dispatcher: NavigationDispatcher):NavigationHandler
}