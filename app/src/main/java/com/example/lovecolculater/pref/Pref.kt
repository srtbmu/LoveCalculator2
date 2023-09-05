package com.example.lovecolculater.pref

import android.content.Context
import android.content.SharedPreferences
import com.example.lovecolculater.App.Companion.SHOWED_KEY
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


class Pref @Inject constructor( private  var preferences : SharedPreferences ) {


    fun isOnBoardingShow(): Boolean {
        return preferences.getBoolean(SHOWED_KEY, false)
    }

    fun onOnBoardingShowed() {
        preferences.edit().putBoolean(SHOWED_KEY, true).apply()
    }

}