package com.bogsnebes.mts.ui.fragments.movie_details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.bogsnebes.mts.R
import com.bogsnebes.mts.data.dto.ActorDto
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.ui.fragments.list_of_movies.MyMoviesAdapter

class ActorsAdapter(
    private val context: Context,
    private val listItems: List<ActorDto>
) : RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_list_actors, parent, false))
    }

    override fun onBindViewHolder(holder: ActorsAdapter.ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageActor = view.findViewById<ImageView>(R.id.imActor)
        private val nameActor = view.findViewById<TextView>(R.id.tvActor)
        fun bind(listItem: ActorDto) {
            imageActor.load("https://image.tmdb.org/t/p/original/" + listItem.imageUrl){
                transformations(
                    RoundedCornersTransformation(
                        cornersRadius
                    )
                )
            }
            nameActor.text = listItem.name
        }
    }

    companion object {
        private const val cornersRadius = 30f
    }
}