package uz.gita.mobilebank.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.mobilebank.data.source.remote.api.Api
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @[Provides Singleton]
    fun provideGson(): Gson = Gson()

    @[Provides Singleton]
    fun provideOkHttp(@ApplicationContext context:Context): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(ChuckerInterceptor(context)).build()
    }

    @[Provides Singleton]
    fun provideRetrofit(okHttpClient:OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("http://195.158.16.140/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)

        .build()

    @[Provides Singleton]
    fun provideApi(retrofit:Retrofit):Api = retrofit.create(Api::class.java)

}