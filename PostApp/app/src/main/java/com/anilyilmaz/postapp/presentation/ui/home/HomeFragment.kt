package com.anilyilmaz.postapp.presentation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import com.anilyilmaz.postapp.R

import com.anilyilmaz.postapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment(){

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
            viewmodel.getUserFromApi()
            viewmodel.getCommentFromApi()
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
