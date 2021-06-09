package com.bangkit.idku.app.home.fragments.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bangkit.idku.app.R
import com.bangkit.idku.app.databinding.FragmentProfileBinding
import com.bangkit.idku.app.home.profile.ChangePasswordActivity
import com.bangkit.idku.app.home.profile.EditProfileActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(), View.OnClickListener {

    private var binding: FragmentProfileBinding? = null
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            binding?.apply {
                viewModel.user?.apply {
                    tvDisplayName.text = displayName ?: email
                }
                btnSignOut.setOnClickListener(::onClick)
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_update_profile -> {
                Intent(requireActivity(), EditProfileActivity::class.java).also {
                    startActivity(it)
                }
            }

            R.id.btn_change_password -> {
                Intent(requireActivity(), ChangePasswordActivity::class.java).also {
                    startActivity(it)
                }
            }

            R.id.btn_sign_out -> {
                viewModel.logout()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}