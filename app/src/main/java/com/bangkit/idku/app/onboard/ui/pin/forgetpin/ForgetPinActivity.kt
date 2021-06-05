package com.bangkit.idku.app.onboard.ui.pin.forgetpin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bangkit.idku.app.databinding.ActivityForgetPinBinding

class ForgetPinActivity : AppCompatActivity() {
    private var binding : ActivityForgetPinBinding? = null
    private lateinit var viewModel : ForgetPinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPinBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[ForgetPinViewModel::class.java]
    }
}