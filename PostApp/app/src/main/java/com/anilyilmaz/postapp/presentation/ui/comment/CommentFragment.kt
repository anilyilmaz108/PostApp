package com.anilyilmaz.postapp.presentation.ui.comment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.databinding.FragmentCommentBinding
import com.anilyilmaz.postapp.databinding.FragmentShareBinding
import com.anilyilmaz.postapp.model.Comment
import com.anilyilmaz.postapp.presentation.ui.home.HomeAdapter
import com.anilyilmaz.postapp.util.Data

class CommentFragment : Fragment() {

    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!

    lateinit var commentAdapter : CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommentBinding.inflate(inflater, container, false)

        for(comment in Data.chosenCommentList){
            Log.e("Comment","${comment.email}")
        }

        binding.CommentRv.apply {
            binding.usernameText.text = Data.chosenUsername
            binding.emailText.text = Data.chosenEmail
            binding.titlePostText.text = Data.chosenTitle
            binding.descriptionPostText.text = Data.chosenBody
            binding.numberOfComment.text = Data.chosenCommentSize.toString()


            val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
            binding.CommentRv.layoutManager = layoutManager
            commentAdapter = CommentAdapter(Data.chosenCommentList)
            binding.CommentRv.adapter = commentAdapter
        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}