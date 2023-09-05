package com.example.lovecolculater.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.lovecolculater.databinding.ItemOnboardingBinding
import com.example.lovecolculater.model.onBoarding
import dagger.hilt.android.AndroidEntryPoint


class Adapter(private val onClick: () -> Unit) : RecyclerView.Adapter<Adapter.onBoardingHolder>() {

    private val data = arrayListOf(
        onBoarding(
            "Art of Love",
            "YWelcome to Love Calculate - your faithful companion in the world of romance and relationships!",
            "https://assets.materialup.com/uploads/ed3c8baf-c488-48a6-8538-cd4fd0bb4955/preview.jpg"
        ),
        onBoarding(
            "Have a good time",
            "You should take the time to help those who need you",
            "https://inside.6q.io/wp-content/uploads/2021/06/6Q-how-to-gather-new-hire-feedback.png"
        ),
        onBoarding(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            "https://png.pngtree.com/png-clipart/20210309/original/pngtree-couple-people-in-love-with-heart-shapes-png-image_5828588.png"
        ),
        onBoarding(
            "Have a breakup?",
            "We have made the correction for you don't worry\nMaybe someone is waiting for you!",
            "https://png.pngtree.com/png-vector/20220720/ourmid/pngtree-breakup-or-separation-of-partners-png-image_6022606.png"
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
        fun bind(onBoarding: onBoarding) {
            with(binding) {
                tvTitle.text = onBoarding.title
                tvDesc.text = onBoarding.text
                Glide.with(imgPoster).load(onBoarding.image).into(imgPoster)
                btnNext.isVisible = adapterPosition == data.lastIndex

                btnNext.setOnClickListener {
                    onClick()
                }
            }

        }
    }
}