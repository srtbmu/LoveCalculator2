package com.example.lovecolculater.presenter

import com.example.lovecolculater.model.Love
import com.example.lovecolculater.pref.Pref
import com.example.lovecolculater.service.RetrofitService
import com.example.lovecolculater.view.FirstView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class FirstPresenter @Inject constructor (private val api:LoveApi) {

    private lateinit var firstView:FirstView
    @Inject
    lateinit var pref:Pref
     fun calculateMatching(first: String, second: String) {
        api.calculateMatching(first, second).enqueue(object :
            Callback<Love> {
            override fun onResponse(call: Call<Love>, response: Response<Love>) {
                firstView.showResult(response.body())
            }

            override fun onFailure(call: Call<Love>, t: Throwable) {
                firstView.showError(t.message ?: "Error")
            }
        })
    }
    fun atachView(view:FirstView){
        this.firstView=view
    }
    fun showOnBoarding(){
        if (!pref.isOnBoardingShow())
            firstView.navigationToOnBoarding()
    }
}