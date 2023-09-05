package com.example.lovecolculater

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecolculater.databinding.FragmentResultBinding
import com.example.lovecolculater.model.Love
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var loveModel:Love

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loveModel = this.arguments?.getSerializable("love") as Love
        binding.tvFirst.text = loveModel.firstname
        binding.tvSecond.text = loveModel.secondName
        binding.tvProcent.text = loveModel.percentage
        binding.tvMassage.text = loveModel.result
        binding.btnTryAgane.setOnClickListener {
            findNavController().navigate(R.id.firstFragment)
        }
    }
}