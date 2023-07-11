package com.anilyilmaz.postapp.presentation.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.databinding.FragmentLoginBinding
import com.anilyilmaz.postapp.presentation.ui.home.HomeViewModel
import com.anilyilmaz.postapp.util.Data


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: LoginViewModel by viewModels()

    var email: String = ""
    var password: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            email = binding.usernameInput.text.toString()
            password = binding.pass.text.toString()

            //viewmodel.validateDataFromApi("Nathan@yesenia.net")
            viewmodel.getUserFromApi()

            viewmodel.userList.observe(viewLifecycleOwner){ user ->

                for (user in Data.userList){
                    if(user.email == email){
                        Data.username = user.username
                        Data.name = user.name
                        Data.email = user.email
                        Data.id = user.id
                        Data.phone = user.phone
                        Data.website = user.website


                        Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                }
                //Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
            }


            //Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
            Log.e("login","$email  --- $password")


            /*viewmodel.validateDataFromApi(email).observe(viewLifecycleOwner){ user ->
                Data.id = user.id
                Data.name = user.name
                Data.username = user.username
                Data.phone = user.phone
                Data.website = user.website
                Log.e("user","${user.username}")
                Log.e("data","${Data.username}")
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
            }*/



        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}