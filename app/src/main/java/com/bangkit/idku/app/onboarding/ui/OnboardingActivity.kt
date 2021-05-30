package com.bangkit.idku.app.onboarding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.idku.app.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityOnboardingBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}