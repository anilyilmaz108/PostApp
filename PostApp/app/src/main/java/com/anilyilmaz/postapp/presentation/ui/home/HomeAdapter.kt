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
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.model.Post
import kotlin.coroutines.coroutineContext

class HomeAdapter(private val postList : ArrayList<Post>)
    : RecyclerView.Adapter<HomeAdapter.RowHolder>() {

    inner class RowHolder(view: View):RecyclerView.ViewHolder(view){
        var usernameTextView: TextView
        var emailTextView: TextView
        var titlePostTextView: TextView
        var descriptionPostTextView: TextView
        var comments: LinearLayout

        init {
            usernameTextView = view.findViewById(R.id.usernameText)
            emailTextView = view.findViewById(R.id.emailText)
            titlePostTextView = view.findViewById(R.id.titlePostText)
            descriptionPostTextView = view.findViewById(R.id.descriptionPostText)
            comments = view.findViewById(R.id.comments)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val post = postList[position]
        holder.usernameTextView.text = "User name"
        holder.emailTextView.text = "User email"
        holder.titlePostTextView.text = post.title
        holder.descriptionPostTextView.text = post.body
        holder.comments.setOnClickListener {
            Log.e("comments","comments tıklandı")
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }


}