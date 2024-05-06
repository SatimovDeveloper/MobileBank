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
    private val DEFAULT_PHONE = "+998900000000"


    fun isShowIntro() = shared.getBoolean(INTRO_KEY, false)
    fun setShowIntro() = shared.edit().putBoolean(INTRO_KEY, true).apply()
    fun setPhoneNumber(number:String) = shared.edit().putString(PHONE_KEY,number).apply()
    fun getPhoneNumber():String = shared.getString(PHONE_KEY,DEFAULT_PHONE)!!
    fun setToken(token:String) = shared.edit().putString(TOKEN_KEY,token).apply()
    fun getToken():String = shared.getString(TOKEN_KEY,"@")!!



}