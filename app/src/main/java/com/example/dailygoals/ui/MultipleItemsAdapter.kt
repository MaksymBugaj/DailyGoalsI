package com.example.dailygoals.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailygoals.R
import com.example.dailygoals.data.db.entity.Goal
import kotlinx.android.synthetic.main.goal_item.view.*

/*
* Created by Maksym Bugaj on 10/31/2019.
*/

class MultipleItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    lateinit var listener: OnItemClickListener
    var listOfGoals = ArrayList<Goal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goal_item, parent, false)
        return LowPriority(view)
    }

    override fun getItemCount(): Int {
        return listOfGoals.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LowPriority).setLowPriorityItem(listOfGoals[position])
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun setGoals(goals: List<Goal>){
        listOfGoals = goals as ArrayList<Goal>
        notifyDataSetChanged()
    }
}


class LowPriority(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    val noteTitle: TextView = itemView.item_note_title
    val noteDescription: TextView = itemView.item_note_description

    fun setLowPriorityItem(item: Goal){

        noteTitle.text = item.name
        noteDescription.text = item.description
    }
}

enum class ItemPriority {
    PRIORITY_LOW,
    PRIORITY_MEDIUM,
    PRIORITY_HIGH
}

interface OnItemClickListener {
    fun onItemClicked(position: Int, view: View)
}