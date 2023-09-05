package com.example.lovecolculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lovecolculater.pref.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//       lateinit var pref: Pref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navController = findNavController(R.id.firstFragment)
//        if (!pref.isOnBoardingShow())
//            navController.navigate(R.id.onBoardingFragment)
    }
}