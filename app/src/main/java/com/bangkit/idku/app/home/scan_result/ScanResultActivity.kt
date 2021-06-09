package com.bangkit.idku.app.home.scan_result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.idku.app.databinding.ActivityScanResultBinding

class ScanResultActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityScanResultBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}