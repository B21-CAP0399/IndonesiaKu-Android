package com.bangkit.idku.app.home.fragments.scan

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bangkit.idku.app.databinding.FragmentScanQrBinding
import com.budiyev.android.codescanner.*
import com.budiyev.android.codescanner.CodeScanner.ALL_FORMATS

class ScanQRFragment : Fragment() {

    //    private val dashboardViewModel: DashboardViewModel
    private var binding: FragmentScanQrBinding? = null
    private lateinit var codeScanner: CodeScanner

    // This property is only valid between onCreateView and
    // onDestroyView.
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
            val scannerView = scannerView
            val activity = requireActivity()
            codeScanner = CodeScanner(activity, scannerView)

            codeScanner.apply {
                camera = CodeScanner.CAMERA_BACK
                formats = ALL_FORMATS
                autoFocusMode = AutoFocusMode.SAFE
                scanMode = ScanMode.CONTINUOUS
                isAutoFocusEnabled = true
                decodeCallback = DecodeCallback {
                    activity.runOnUiThread {
                    }
                }
                errorCallback = ErrorCallback {
                    activity.runOnUiThread {
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