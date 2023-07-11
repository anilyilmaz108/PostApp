package com.anilyilmaz.postapp.presentation.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.databinding.FragmentHomeBinding
import com.anilyilmaz.postapp.databinding.FragmentLoginBinding
import com.anilyilmaz.postapp.model.Post
import com.anilyilmaz.postapp.util.ApiUtils
import com.anilyilmaz.postapp.util.Data
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var homeAdapter : HomeAdapter
    //var postList = ArrayList<Post>()
    private val viewmodel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.toolbar.title = "PostApp"



        binding.recyclerView.apply {
            viewmodel.getDataFromApi()
            val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
            binding.recyclerView.layoutManager = layoutManager
            //homeAdapter = HomeAdapter(Data.postList)
            //Log.e("Home","----> ${viewmodel.getDataFromApi()}")
            viewmodel.getDataFromApi().observe(viewLifecycleOwner){
                //Log.e("aa","***** ${it.size}")
                homeAdapter = HomeAdapter(it)
                binding.recyclerView.adapter = homeAdapter
            }
            //Log.e("Home","----> ${viewmodel.postList.value!!.size}")
            //homeAdapter = HomeAdapter(viewmodel.postList.value!!)

            //println("${Data.postList.size}")
        }


        //Log.e("phone","${Data.phone}")

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}