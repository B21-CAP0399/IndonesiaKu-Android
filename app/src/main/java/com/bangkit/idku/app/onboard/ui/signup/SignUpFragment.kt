package com.bangkit.idku.app.onboard.ui.signup

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bangkit.idku.app.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private var binding: FragmentSignInBinding? = null
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            edtEmail.doOnTextChanged { email, _, _, count ->
                viewModel.email.value = email.toString()
                if(isEmailValid(email.toString())){
                    edtEmail.hideError()
                } else {
                    edtEmail.showError("Email is not valid")
                }
            }
            edtPassword.doOnTextChanged { password, _, _, _ ->
                viewModel.password.value = password.toString()
            }
            edtConfirmPassword.doOnTextChanged { confirmPassword, _, _, _ ->
                viewModel.confirmPassword.value = confirmPassword.toString()
            }

            btnSignIn.setOnClickListener { viewModel.signUp() }
        }
    }

    private fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun EditText.showError(message: String){
        error = message
    }

    private fun EditText.hideError(){
        error = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}