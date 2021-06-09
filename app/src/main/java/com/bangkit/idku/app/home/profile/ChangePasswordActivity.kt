package com.bangkit.idku.app.home.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.idku.app.R
import com.bangkit.idku.app.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityChangePasswordBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.title_change_password)
    }
}