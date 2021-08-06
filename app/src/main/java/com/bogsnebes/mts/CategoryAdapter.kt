package com.bogsnebes.mts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val context: Context, private val listItems: List<String>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_category, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems[position], context)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvCategory: TextView = view.findViewById(R.id.tvCategory)

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, "${tvCategory.text}", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(listItem: String, context: Context) {
            tvCategory.text = listItem
        }
    }
}