package com.bangkit.idku.app.onboard.ui.pin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bangkit.idku.app.R
import com.bangkit.idku.app.databinding.ActivityPinBinding

class PinActivity : AppCompatActivity(), View.OnClickListener {

    private var binding : ActivityPinBinding? = null
    private lateinit var viewModel : PinViewModel
    private lateinit var txtPin : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPinBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[PinViewModel::class.java]

        binding?.btnEnter?.setOnClickListener(this)
        binding?.btnForgetPin?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_enter -> {
                txtPin = binding?.edtPin?.text.toString()
                if (pinValidation(txtPin)){
                    txtPin = binding?.edtPin?.text.toString()
                    val action = PinActivityDirections.actionPinActivityToNavigationHome()
                    v?.findNavController().navigate(action)
                }else{
                    binding?.txtWrongPin?.text = "Your PIN is Wrong"
                    binding?.edtPin?.text?.clear()
                }
            }
            R.id.btn_forget_pin -> {
                val action = PinActivityDirections.actionPinActivityToForgetPinActivity()
                v?.findNavController().navigate(action)
            }
        }
    }

    private fun pinValidation(pin : String) : Boolean{
        val numberPin = Integer.parseInt(pin)
        return viewModel.getValidationPin(numberPin)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}