package uz.gita.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebank.domain.auth.AuthRepository
import uz.gita.mobilebank.domain.auth.imp.AuthRepositoryImp

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun getAuthRepository(impl:AuthRepositoryImp):AuthRepository
}