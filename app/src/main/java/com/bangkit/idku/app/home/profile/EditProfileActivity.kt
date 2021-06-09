package com.bangkit.idku.app.home.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.idku.app.R
import com.bangkit.idku.app.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityEditProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.title_edit_profile)
    }
}