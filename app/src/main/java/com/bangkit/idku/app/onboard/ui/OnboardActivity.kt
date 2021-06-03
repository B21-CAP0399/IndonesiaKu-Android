package com.bangkit.idku.app.onboard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.idku.app.databinding.ActivityOnboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityOnboardBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}