package com.anilyilmaz.postapp.presentation.ui.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.databinding.FragmentShareBinding
import com.anilyilmaz.postapp.databinding.FragmentTodoBinding
import com.anilyilmaz.postapp.presentation.ui.home.HomeAdapter
import com.anilyilmaz.postapp.presentation.ui.home.HomeViewModel


class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    lateinit var todoAdapter : TodoAdapter
    private val viewmodel: TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)

        binding.todoToolbar.title = "To-Do"



        binding.RVTodo.apply {
            viewmodel.getTodoFromApi()
            val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
            binding.RVTodo.layoutManager = layoutManager

            viewmodel.getTodoFromApi().observe(viewLifecycleOwner){
                binding.todoNumber.text = "${it.size} items"
                todoAdapter = TodoAdapter(it)
                binding.RVTodo.adapter = todoAdapter
            }
        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}