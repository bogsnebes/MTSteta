package com.bogsnebes.mts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val listItems: List<String>, private val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvText: TextView = view.findViewById(R.id.tvCategory)

        fun bind(listItem: String, context: Context) {
            tvText.text = listItem

            itemView.setOnClickListener {
                Toast.makeText(context, "${tvText.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_category, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listItems[position]
        holder.bind(listItem, context)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}