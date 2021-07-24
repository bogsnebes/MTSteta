package com.bogsnebes.mts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(listItems: List<String>, context: Context) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    val listItemsR = listItems
    val contextR = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvText = view.findViewById<TextView>(R.id.text_category)

        fun bind(listItem: String, context: Context) {
            tvText.text = listItem

            itemView.setOnClickListener {
                Toast.makeText(context, "${tvText.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_category, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listItemsR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listItemsR.size
    }
}