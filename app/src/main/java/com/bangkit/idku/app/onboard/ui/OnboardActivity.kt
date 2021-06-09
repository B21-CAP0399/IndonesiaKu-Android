package com.bangkit.idku.app.onboard.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.idku.app.databinding.ActivityOnboardBinding
import com.bangkit.idku.app.home.HomeActivity
import com.bangkit.idku.app.onboard.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityOnboardBinding.inflate(layoutInflater)
    }
    private val viewModel: LoginViewModel by viewModels()

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(viewModel.user != null){
            Intent(this, HomeActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}