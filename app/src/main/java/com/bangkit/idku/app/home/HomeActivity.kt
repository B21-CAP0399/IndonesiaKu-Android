package com.bangkit.idku.app.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.idku.app.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}