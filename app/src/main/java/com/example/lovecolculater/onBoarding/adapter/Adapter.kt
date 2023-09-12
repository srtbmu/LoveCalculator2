package com.example.lovecolculater.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecolculater.R
import com.example.lovecolculater.databinding.ItemOnboardingBinding
import com.example.lovecolculater.model.onBoarding


class Adapter(private val onClick: () -> Unit) : RecyclerView.Adapter<Adapter.onBoardingHolder>() {

    private val data = arrayListOf(
        onBoarding(
            "Art of Love",
            "YWelcome to Love Calculate - your faithful companion in the world of romance and relationships!",
            R.raw.animation_lmfwdtwq
        ),
        onBoarding(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.animation_lmfy9owe
        ),
        onBoarding(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.raw.animation_lmfybeqq
        ),
        onBoarding(
            "Have a breakup?",
            "We have made the correction for you don't worry\nMaybe someone is waiting for you!",
            R.raw.animation_lmfychb4
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingHolder {
        return onBoardingHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: onBoardingHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class onBoardingHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        //        fun bind(onBoarding: onBoarding) {
//            with(binding) {
//                tvTitle.text = onBoarding.title
//                tvDesc.text = onBoarding.text
//                Glide.with(animationView).load(onBoarding.image).into(animationView)
//                btnNext.isVisible = adapterPosition == data.lastIndex
//
//                btnNext.setOnClickListener {
//                    onClick()
//                }
//            }
//        }
        fun bind(onBoarding: onBoarding) {
            with(binding) {
                tvTitle.text = onBoarding.title
                tvDesc.text = onBoarding.text
                onBoarding.image.let { animationView.setAnimation(it) }
                //Glide.with(animationView).load(onBoarding.image).into(animationView)
                btnNext.isVisible = adapterPosition == data.lastIndex
                btnNext.setOnClickListener {
                    onClick()
                }
            }
        }
    }
}