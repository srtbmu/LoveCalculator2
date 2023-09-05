package com.example.lovecolculater.module

import android.content.Context
import android.content.SharedPreferences
import com.example.lovecolculater.App.Companion.SHOWED_KEY
import com.example.lovecolculater.presenter.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun providePref (@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(SHOWED_KEY, Context.MODE_PRIVATE)
    }

}
