package com.bangkit.idku.app.onboard.ui.pin.newpin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bangkit.idku.app.R
import com.bangkit.idku.app.databinding.ActivityNewPinBinding

class NewPinActivity : AppCompatActivity(), View.OnClickListener {

    private var binding : ActivityNewPinBinding? = null
    private lateinit var viewModel : NewPinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPinBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[NewPinViewModel::class.java]

        binding?.btnSendNewPin?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_send_new_pin){
            val newPin = binding?.edtNewPin?.text.toString()
            val confirmPin = binding?.edtConfirmPin?.text.toString()
            val samePin = !confirmPin.equals(newPin)
            if (samePin){
                binding?.edtConfirmPin?.error = getString(R.string.txt_not_same_pin)
            }else{
                val action = NewPinActivityDirections.actionNewPinActivityToPinActivity()
                v?.findNavController().navigate(action)
            }
        }
    }
}