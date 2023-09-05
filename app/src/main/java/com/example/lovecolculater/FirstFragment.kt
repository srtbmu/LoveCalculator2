package com.example.lovecolculater

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.lovecolculater.R
import androidx.navigation.fragment.findNavController
import com.example.lovecolculater.databinding.FragmentFirstBinding
import com.example.lovecolculater.model.Love
import com.example.lovecolculater.presenter.FirstPresenter
import com.example.lovecolculater.view.FirstView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment(),FirstView {

    private lateinit var binding: FragmentFirstBinding
    @Inject
     lateinit var presenter: FirstPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        presenter.atachView(this)
        presenter.showOnBoarding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        binding.history.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }

    }


   override fun initClicker() {
        binding.btnCalculate.setOnClickListener {
            presenter.calculateMatching(
                binding.etYou.text.toString(),
                binding.etMe.text.toString()
            )
        }

    }
    override  fun showResult(loveModel: Love?) {
      App.appDataBase.loveDao().insert(loveModel)
        findNavController().navigate(R.id.resultFragment, bundleOf("love" to loveModel))

    }

   override fun showError(message: String) {
        Log.e("ololo", "Error:$message")
    }

    override fun navigationToOnBoarding() {
        findNavController().navigate(R.id.onBoardingFragment)
    }
}
