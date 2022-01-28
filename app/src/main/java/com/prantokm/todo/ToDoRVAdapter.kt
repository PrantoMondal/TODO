package com.prantokm.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoRVAdapter(private val context:Context,private val listener:IToDoRVAdapter) : RecyclerView.Adapter<ToDoRVAdapter.ToDoViewHolder>(){

    val allTask = ArrayList<ToDo>()

    inner class ToDoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text)
        val checkBox = itemView.findViewById<CheckBox>(R.id.CheckBox)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val viewHolder = ToDoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_todo,parent,false))
        viewHolder.checkBox.setOnClickListener{
            listener.onItemClicked(allTask[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allTask.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentToDo = allTask[position]
        holder.textView.text = currentToDo.text
    }

    fun updateList(newList:List<ToDo>){
        allTask.clear()
        allTask.addAll(newList)

        notifyDataSetChanged()
    }

}
interface IToDoRVAdapter{
    fun onItemClicked(toDo: ToDo)
}