package com.example.lovecolculater.view

import com.example.lovecolculater.model.Love

interface FirstView  {

    fun initClicker()
    fun showResult(loveModel: Love?)
    fun showError(message: String)
    fun navigationToOnBoarding()
}