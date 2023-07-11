package com.anilyilmaz.postapp.presentation.ui.comment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.model.Comment
import com.anilyilmaz.postapp.model.Todo

class CommentAdapter(private val commentList : ArrayList<Comment>)
    : RecyclerView.Adapter<CommentAdapter.RowHolder>() {

    inner class RowHolder(view: View): RecyclerView.ViewHolder(view){
        var emailId: TextView
        var bodyId: TextView


        init {
            emailId = view.findViewById(R.id.emailId)
            bodyId = view.findViewById(R.id.bodyId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val comment = commentList[position]
        holder.emailId.text = comment.email.split("@")[0]
        holder.bodyId.text = comment.body

    }

    override fun getItemCount(): Int {
        return commentList.size
    }


}