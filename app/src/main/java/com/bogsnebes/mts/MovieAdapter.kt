package com.bogsnebes.mts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.bogsnebes.mts.data.dto.MovieDto

class MyMoviesAdapter(listItems: List<MovieDto>, context: Context) :
    RecyclerView.Adapter<MyMoviesAdapter.ViewHolder>() {
    val listItemsR = listItems
    val contextR = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.movie_title)
        val tvDescription = view.findViewById<TextView>(R.id.movie_description)
        val tvStars = listOf(
            view.findViewById<ImageView>(R.id.star_1),
            view.findViewById<ImageView>(R.id.star_2),
            view.findViewById<ImageView>(R.id.star_3),
            view.findViewById<ImageView>(R.id.star_4),
            view.findViewById<ImageView>(R.id.star_5)
        )
        val tvAge = view.findViewById<TextView>(R.id.movie_age)
        val tvImage = view.findViewById<ImageView>(R.id.movie_image)

        fun bind(listItem: MovieDto, context: Context) {
            tvTitle.text = listItem.title
            tvDescription.text = listItem.description
            tvAge.text = listItem.ageRestriction.toString() + "+"
            tvImage.load(listItem.imageUrl) { transformations(RoundedCornersTransformation(30f)) }
            when (listItem.rateScore) {
                0 -> {
                    tvStars[0].setImageResource(R.drawable.ic_empty_star)
                    tvStars[1].load(R.drawable.ic_empty_star)
                    tvStars[2].load(R.drawable.ic_empty_star)
                    tvStars[3].load(R.drawable.ic_empty_star)
                    tvStars[4].load(R.drawable.ic_empty_star)
                }

                1 -> {
                    tvStars[0].load(R.drawable.ic_fill_star)
                    tvStars[1].load(R.drawable.ic_empty_star)
                    tvStars[2].load(R.drawable.ic_empty_star)
                    tvStars[3].load(R.drawable.ic_empty_star)
                    tvStars[4].load(R.drawable.ic_empty_star)
                }
                2 -> {
                    tvStars[0].load(R.drawable.ic_fill_star)
                    tvStars[1].load(R.drawable.ic_fill_star)
                    tvStars[2].load(R.drawable.ic_empty_star)
                    tvStars[3].load(R.drawable.ic_empty_star)
                    tvStars[4].load(R.drawable.ic_empty_star)
                }
                3 -> {
                    tvStars[0].load(R.drawable.ic_fill_star)
                    tvStars[1].load(R.drawable.ic_fill_star)
                    tvStars[2].load(R.drawable.ic_fill_star)
                    tvStars[3].load(R.drawable.ic_empty_star)
                    tvStars[4].load(R.drawable.ic_empty_star)
                }
                4 -> {
                    tvStars[0].load(R.drawable.ic_fill_star)
                    tvStars[1].load(R.drawable.ic_fill_star)
                    tvStars[2].load(R.drawable.ic_fill_star)
                    tvStars[3].load(R.drawable.ic_fill_star)
                    tvStars[4].load(R.drawable.ic_empty_star)
                }
                5 -> {
                    tvStars[0].load(R.drawable.ic_fill_star)
                    tvStars[1].load(R.drawable.ic_fill_star)
                    tvStars[2].load(R.drawable.ic_fill_star)
                    tvStars[3].load(R.drawable.ic_fill_star)
                    tvStars[4].load(R.drawable.ic_fill_star)
                }
                else -> TODO("Добавить исключение")
            }

            itemView.setOnClickListener {
                Toast.makeText(context, "${tvTitle.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return listItemsR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listItemsR.get(position)
        holder.bind(listItem, contextR)
    }

}