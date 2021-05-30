package com.bangkit.idku.app.home.fragments.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.idku.app.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    //    private lateinit var notificationsViewModel: NotificationsViewModel
    private var binding: FragmentNotificationsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}