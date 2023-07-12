package com.anilyilmaz.postapp.presentation.ui.share

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.anilyilmaz.postapp.R

import com.anilyilmaz.postapp.databinding.FragmentShareBinding
import com.anilyilmaz.postapp.presentation.ui.home.HomeViewModel
import com.anilyilmaz.postapp.presentation.ui.login.LoginViewModel
import com.anilyilmaz.postapp.util.Data
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class ShareFragment : Fragment() {

    private var _binding: FragmentShareBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: ShareViewModel by viewModels()
    //val viewmodel: ShareViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShareBinding.inflate(inflater, container, false)

        binding.usernameLabel.text = Data.username
        binding.emailLabel.text = Data.email
        binding.submitButton.setOnClickListener {
            viewmodel.postData(Data.id, binding.createTitle.text.toString(), binding.createBody.text.toString())
            binding.createTitle.text.clear()
            binding.createBody.text.clear()
            Snackbar.make(
                it,
                "Post sharing operation successful",
                Snackbar.LENGTH_SHORT
            ).show()
        }


        val view = binding.root
        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}