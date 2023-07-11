package com.anilyilmaz.postapp.presentation.ui.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.postapp.R
import com.anilyilmaz.postapp.model.Todo

class TodoAdapter(private val todoList : ArrayList<Todo>)
    : RecyclerView.Adapter<TodoAdapter.RowHolder>() {

    inner class RowHolder(view: View): RecyclerView.ViewHolder(view){
        var todoTextView: TextView
        var todoCard: CardView
        var checkTodo: CheckBox
        var todoText: TextView


        init {
            todoTextView = view.findViewById(R.id.todoText)
            todoCard = view.findViewById(R.id.todoCard)
            checkTodo = view.findViewById(R.id.checkTodo)
            todoText = view.findViewById(R.id.todoText)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val todo = todoList[position]
        holder.todoTextView.text = todo.title

        holder.todoCard.setOnClickListener {
            todo.completed != todo.completed
            holder.checkTodo.isChecked != holder.checkTodo.isChecked
        }

    }

    override fun getItemCount(): Int {
        return todoList.size
    }


}