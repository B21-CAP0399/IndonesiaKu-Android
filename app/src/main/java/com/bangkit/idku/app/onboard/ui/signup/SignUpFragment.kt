package com.bangkit.idku.app.onboard.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bangkit.idku.app.R
import com.bangkit.idku.app.databinding.FragmentSignUpBinding
import com.bangkit.idku.app.utils.hideError
import com.bangkit.idku.app.utils.isEmailValid
import com.bangkit.idku.app.utils.isPasswordValid
import com.bangkit.idku.app.utils.showError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

@AndroidEntryPoint
class SignUpFragment : Fragment(), View.OnClickListener {
    private var binding: FragmentSignUpBinding? = null
    private val viewModel: SignUpViewModel by viewModels()

    private val emailState = MutableStateFlow(String())
    private val passwordState = MutableStateFlow(String())
    private val confirmPasswordState = MutableStateFlow(String())


    private val formIsValid = combine(
        emailState,
        passwordState,
        confirmPasswordState
    ) { email, password, confirmPassword ->
        isEmailValid(email) and isPasswordValid(password) and (password == confirmPassword)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            edtEmail.editText?.apply {
                doOnTextChanged { email, _, _, _ ->
                    emailState.value = email.toString()
                    if (isEmailValid(email.toString())) {
                        hideError()
                    } else {
                        showError("Email is not valid")
                    }
                }
            }
            edtPassword.editText?.apply {
                doOnTextChanged { password, _, _, _ ->
                    passwordState.value = password.toString()
                }
            }

            edtConfirmPassword.editText?.apply {
                doOnTextChanged { confirmPassword, _, _, _ ->
                    confirmPasswordState.value = confirmPassword.toString()
                }
            }
            btnSignUp.setOnClickListener(::onClick)
            btnToLogin.setOnClickListener(::onClick)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_sign_up) {
            viewModel.signUp(emailState.value, passwordState.value, confirmPasswordState.value)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val action = SignUpFragmentDirections.actionToLoginFragment(true)
                        findNavController().navigate(action)
                    }
                }
        }else if(v?.id == R.id.btn_to_login){
            val action = SignUpFragmentDirections.actionToLoginFragment()
            findNavController().navigate(action)
        }

    }

}