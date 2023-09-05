package com.example.lovecolculater.view

import android.os.Bundle
import com.example.lovecolculater.model.Love

interface ResultView {
    interface View {
        fun displayLoveModel(loveModel: Love?)
        fun navigateToMainFragment()
    }

    interface Presenter {
        fun onViewCreated(argument: Bundle?)
        fun onTryButtonClick()
    }
}