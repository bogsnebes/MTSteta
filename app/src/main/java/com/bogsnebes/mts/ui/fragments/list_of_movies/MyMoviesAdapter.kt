package com.bogsnebes.mts.ui.fragments.list_of_movies

import android.annotation.SuppressLint
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
import com.bogsnebes.mts.data.dto.MovieDto

class MyMoviesAdapter(
    private val context: Context,
    private val listItems: List<MovieDto>,
    private val callback: (MovieDto) -> Unit
) :
    RecyclerView.Adapter<MyMoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvMovieTitle)
        private val description = view.findViewById<TextView>(R.id.tvMovieDescription)
        private val star by lazy {
            listOf(
                view.findViewById(R.id.star_1),
                view.findViewById(R.id.ivStar_2),
                view.findViewById(R.id.ivStar_3),
                view.findViewById(R.id.ivStar_4),
                view.findViewById<ImageView>(R.id.ivStar_5)
            )
        }
        private val age = view.findViewById<TextView>(R.id.tvAge)
        private val image = view.findViewById<ImageView>(R.id.ivMovie)

        @SuppressLint("SetTextI18n")
        fun bind(listItem: MovieDto) {
            title.text = listItem.title
            description.text = if (listItem.description.length > 150) listItem.description.substring(
                0,
                150
            ) + "..." else listItem.description
            if (listItem.ageRestriction)
                age.text = "18+"
            else
                age.text = "0+"
            image.load("https://image.tmdb.org/t/p/original/" + listItem.imageUrl) {
                transformations(
                    RoundedCornersTransformation(
                        cornersRadius
                    )
                )
            }

            for (i in 0 until listItem.rateScore.toInt() / 2) {
                star[i].load(R.drawable.ic_fill_star)
            }

            for (i in listItem.rateScore.toInt() / 2 until 5) {
                star[i].load(R.drawable.ic_empty_star)
            }

            itemView.setOnClickListener {
                callback.invoke(listItem)
            }
        }
    }

    companion object {
        private const val cornersRadius = 30f
    }
}