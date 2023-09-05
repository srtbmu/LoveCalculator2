package com.example.lovecolculater.presenter

import android.os.Bundle
import com.example.lovecolculater.model.Love
import com.example.lovecolculater.view.ResultView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class ResultPresenter @Inject constructor(private val view: ResultView.View):ResultView.Presenter {
    private lateinit var loveModel: Love
    override fun onViewCreated(argument: Bundle?) {
        loveModel = argument?.getSerializable("love") as Love
        view.displayLoveModel(loveModel)
    }

    override fun onTryButtonClick() {
        view.navigateToMainFragment()
    }
}