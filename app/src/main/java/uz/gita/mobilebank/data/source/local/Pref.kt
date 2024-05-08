package uz.gita.mobilebank.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Pref @Inject constructor(
    private val shared: SharedPreferences
) {
    private val INTRO_KEY = "Intro"
    private val PHONE_KEY = "Phone"
    private val TOKEN_KEY = "Token"
    private val REFRESH_TOKEN_KEY = "refreshToken"
    private val ACCESS_TOKEN_KEY = "accessToken"
    private val DEFAULT_TOKEN = "@"
    private val DEFAULT_PHONE = "+998900000000"


    fun isShowIntro() = shared.getBoolean(INTRO_KEY, false)
    fun setShowIntro() = shared.edit().putBoolean(INTRO_KEY, true).apply()
    fun setPhoneNumber(number:String) = shared.edit().putString(PHONE_KEY,number).apply()
    fun getPhoneNumber():String = shared.getString(PHONE_KEY,DEFAULT_PHONE)!!
    fun setToken(token:String) = shared.edit().putString(TOKEN_KEY,token).apply()
    fun getToken():String = shared.getString(TOKEN_KEY,DEFAULT_TOKEN)!!
    fun setAccessToken(accessToken:String) = shared.edit().putString(ACCESS_TOKEN_KEY,accessToken).apply()
    fun getAccessToken():String = shared.getString(ACCESS_TOKEN_KEY,DEFAULT_TOKEN)!!
    fun setRefreshToken(refreshToken:String) = shared.edit().putString(REFRESH_TOKEN_KEY,refreshToken).apply()
    fun getRefreshToken():String = shared.getString(REFRESH_TOKEN_KEY,DEFAULT_TOKEN)!!



}