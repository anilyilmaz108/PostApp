package com.anilyilmaz.postapp.presentation.ui.home

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.model.Comment
import com.anilyilmaz.postapp.model.Post
import com.anilyilmaz.postapp.util.Data
import kotlin.coroutines.coroutineContext

class HomeAdapter(private val postList : ArrayList<Post>)
    : RecyclerView.Adapter<HomeAdapter.RowHolder>() {
    var commentSize = 0

    inner class RowHolder(view: View):RecyclerView.ViewHolder(view){
        var usernameTextView: TextView
        var emailTextView: TextView
        var titlePostTextView: TextView
        var descriptionPostTextView: TextView
        var comments: LinearLayout
        var numberOfComments: TextView

        init {

            usernameTextView = view.findViewById(R.id.usernameText)
            emailTextView = view.findViewById(R.id.emailText)
            titlePostTextView = view.findViewById(R.id.titlePostText)
            descriptionPostTextView = view.findViewById(R.id.descriptionPostText)
            comments = view.findViewById(R.id.comments)
            numberOfComments = view.findViewById(R.id.numberOfComment)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val post = postList[position]

        for(user in Data.userAllList){
            if(user.id == post.userId){
                holder.usernameTextView.text = user.username
                holder.emailTextView.text = user.email
                Data.chosenEmail = user.email
                Data.chosenUsername = user.username
            }
        }

        Data.chosenCommentList.clear()
        for(comment in Data.userAllComment){
            if(comment.postId == post.id){
                commentSize++
                Data.chosenCommentList.add(comment)
            }
        }

        holder.titlePostTextView.text = post.title
        holder.descriptionPostTextView.text = post.body
        holder.comments.setOnClickListener {
            Log.e("comments","comments tıklandı")
        }
        holder.numberOfComments.text = commentSize.toString()

        holder.comments.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_commentFragment)

        }

        Data.chosenTitle = post.title
        Data.chosenBody = post.body
        Data.chosenCommentSize = commentSize
    }

    override fun getItemCount(): Int {
        return postList.size
    }


}