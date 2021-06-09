package com.bangkit.idku.app.home.fragments.scan

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bangkit.idku.app.databinding.FragmentScanQrBinding
import com.budiyev.android.codescanner.*
import com.budiyev.android.codescanner.CodeScanner.ALL_FORMATS
import kotlinx.coroutines.launch

class ScanQRFragment : Fragment() {
    private val viewModel: ScanQRViewModel by viewModels()
    private var binding: FragmentScanQrBinding? = null
    private lateinit var codeScanner: CodeScanner


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScanQrBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestCameraPermission()
        qrCodeScanner()
    }

    private fun qrCodeScanner() {
        binding?.apply {
            codeScanner = CodeScanner(requireActivity(), scannerView)

            codeScanner.apply {
                camera = CodeScanner.CAMERA_BACK
                formats = ALL_FORMATS
                autoFocusMode = AutoFocusMode.SAFE
                scanMode = ScanMode.CONTINUOUS
                isAutoFocusEnabled = true
                decodeCallback = DecodeCallback {
                    lifecycleScope.launch {
                        Toast.makeText(context, it.text, LENGTH_SHORT).show()
                        viewModel.getAccessPermission(it.text)
                    }
                }
                errorCallback = ErrorCallback {
                    activity?.runOnUiThread {
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
            scannerView.setOnClickListener {
                codeScanner.startPreview()
            }
        }
    }

    private fun requestCameraPermission() {
        val permission =
            ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            requireActivity(), arrayOf(android.Manifest.permission.CAMERA), CAMERA_REQUEST_CODE
        )
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(activity, "Permission Denied", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(activity, "Permission Allowed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    companion object {
        private const val CAMERA_REQUEST_CODE = 100
    }
}