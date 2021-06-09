package com.bangkit.idku.app.onboard.ui.login

import android.R.attr
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bangkit.idku.app.R
import com.bangkit.idku.app.databinding.FragmentLoginBinding
import com.bangkit.idku.app.home.HomeActivity
import com.bangkit.idku.app.utils.*
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class LoginFragment : Fragment(), View.OnClickListener {
    private var binding: FragmentLoginBinding? = null
    private val viewModel: LoginViewModel by activityViewModels()

    private val emailState = MutableStateFlow("")
    private val passwordState = MutableStateFlow("")
    private val formIsValid = combine(
        emailState,
        passwordState
    ) { email, password -> isEmailValid(email) and isPasswordValid(password) }
    private val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            binding?.apply {
                if (args.signedUp) {
                    root.showSnackbar("Check your email for account verification!")
                }

                edtEmail.editText?.apply {
                    doOnTextChanged { email, _, _, _ ->
                        emailState.value = email.toString()
                        val emailIsValid = isEmailValid(email.toString())
                        when {
                            emailIsValid.not() -> showError(getString(R.string.error_edit_email))
                            emailIsValid -> hideError()
                        }
                    }
                }

                edtPassword.editText?.apply {
                    doOnTextChanged { password, _, _, _ ->
                        passwordState.value = password.toString()
                        val passwordIsValid = isPasswordValid(password.toString())
                        when {
                            passwordIsValid.not() -> showError(getString(R.string.error_edit_password))
                            passwordIsValid -> hideError()
                        }
                    }
                }

                viewLifecycleOwner.lifecycleScope.launch {
                    formIsValid.collect { formIsValidState -> btnLogin.isEnabled = formIsValidState }
                }

                btnToSignUp.setOnClickListener(::onClick)
                btnLogin.setOnClickListener(::onClick)
            }
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_login) {
            viewModel.login(emailState.value, passwordState.value)
                .addOnCompleteListener { task ->
                    Timber.d(task.result.toString())
                    if (task.isSuccessful) {
                        Intent(activity, HomeActivity::class.java).also {
                            it.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }
                    } else {
                        Timber.e(task.exception)
                    }
                }
        } else if (v?.id == R.id.btn_to_sign_up) {
            val action = LoginFragmentDirections.actionToSignUpFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}