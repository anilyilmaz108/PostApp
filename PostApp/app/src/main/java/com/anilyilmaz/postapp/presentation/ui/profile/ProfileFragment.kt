package com.anilyilmaz.postapp.presentation.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.databinding.FragmentHomeBinding
import com.anilyilmaz.postapp.databinding.FragmentProfileBinding
import com.anilyilmaz.postapp.util.Data


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.textView.text = Data.name
        binding.textView2.text = Data.username
        binding.email.text = Data.email
        binding.username.text = Data.username
        binding.phone.text = Data.phone
        binding.web.text = Data.website
        binding.logout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_profileFragment_to_loginFragment)
        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}