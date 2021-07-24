package com.bogsnebes.mts

import android.annotation.SuppressLint
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

class MyMoviesAdapter(private val listItems: List<MovieDto>, private val context: Context) :
    RecyclerView.Adapter<MyMoviesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tvMovie_title)
        private val description = view.findViewById<TextView>(R.id.tvMovie_description)
        private val stars by lazy {
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
        fun bind(listItem: MovieDto, context: Context) {
            title.text = listItem.title
            description.text = listItem.description
            age.text = listItem.ageRestriction.toString() + "+"
            image.load(listItem.imageUrl) { transformations(RoundedCornersTransformation(30f)) }
            when (listItem.rateScore) {
                0 -> {
                    stars[0].setImageResource(R.drawable.ic_empty_star)
                    stars[1].load(R.drawable.ic_empty_star)
                    stars[2].load(R.drawable.ic_empty_star)
                    stars[3].load(R.drawable.ic_empty_star)
                    stars[4].load(R.drawable.ic_empty_star)
                }

                1 -> {
                    stars[0].load(R.drawable.ic_fill_star)
                    stars[1].load(R.drawable.ic_empty_star)
                    stars[2].load(R.drawable.ic_empty_star)
                    stars[3].load(R.drawable.ic_empty_star)
                    stars[4].load(R.drawable.ic_empty_star)
                }
                2 -> {
                    stars[0].load(R.drawable.ic_fill_star)
                    stars[1].load(R.drawable.ic_fill_star)
                    stars[2].load(R.drawable.ic_empty_star)
                    stars[3].load(R.drawable.ic_empty_star)
                    stars[4].load(R.drawable.ic_empty_star)
                }
                3 -> {
                    stars[0].load(R.drawable.ic_fill_star)
                    stars[1].load(R.drawable.ic_fill_star)
                    stars[2].load(R.drawable.ic_fill_star)
                    stars[3].load(R.drawable.ic_empty_star)
                    stars[4].load(R.drawable.ic_empty_star)
                }
                4 -> {
                    stars[0].load(R.drawable.ic_fill_star)
                    stars[1].load(R.drawable.ic_fill_star)
                    stars[2].load(R.drawable.ic_fill_star)
                    stars[3].load(R.drawable.ic_fill_star)
                    stars[4].load(R.drawable.ic_empty_star)
                }
                5 -> {
                    stars[0].load(R.drawable.ic_fill_star)
                    stars[1].load(R.drawable.ic_fill_star)
                    stars[2].load(R.drawable.ic_fill_star)
                    stars[3].load(R.drawable.ic_fill_star)
                    stars[4].load(R.drawable.ic_fill_star)
                }
                else -> TODO("Добавить исключение")
            }

            itemView.setOnClickListener {
                Toast.makeText(context, "${title.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listItems[position]
        holder.bind(listItem, context)
    }

}