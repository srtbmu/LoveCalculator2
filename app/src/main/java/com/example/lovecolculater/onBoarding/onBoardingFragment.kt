package com.example.lovecolculater.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecolculater.R
import com.example.lovecolculater.databinding.FragmentOnBoardingBinding
import com.example.lovecolculater.onBoarding.adapter.Adapter
import com.example.lovecolculater.pref.Pref
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class onBoardingFragment : Fragment() {

    private  lateinit var  binding: FragmentOnBoardingBinding
    private var adapter:Adapter= Adapter(this::onClick)
     @Inject
    lateinit var pref: Pref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpagerOnboarding.adapter=adapter
        binding.indicator.setViewPager(binding.viewpagerOnboarding)
    }
    fun onClick(){
        pref.onOnBoardingShowed()
        findNavController().navigate(R.id.firstFragment)
    }

}