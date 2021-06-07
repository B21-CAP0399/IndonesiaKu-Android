package com.bangkit.idku.app.onboard.ui.pin.entryotp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bangkit.idku.app.R
import com.bangkit.idku.app.databinding.ActivityEntryOtpBinding

class EntryOtpActivity : AppCompatActivity() {

    private var binding : ActivityEntryOtpBinding? = null
    private lateinit var viewModel: EntryOtpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryOtpBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[EntryOtpViewModel::class.java]
    }
}