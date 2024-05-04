package uz.gita.mobilebank.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Pref @Inject constructor(
    private val shared: SharedPreferences
) {
    private val INTRO_KEY = "Intro"

    fun isShowIntro() = shared.getBoolean(INTRO_KEY, false)
    fun setShowIntro() = shared.edit().putBoolean(INTRO_KEY, true).apply()

}