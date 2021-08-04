package com.bogsnebes.mts

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import coil.load
import com.bogsnebes.mts.data.dto.MovieDto

class FragmentMovieDetails : Fragment(R.layout.fragment_movie_details) {

    private lateinit var background: ImageView
    private lateinit var date: TextView
    private lateinit var title: TextView
    private lateinit var star: List<ImageView>
    private lateinit var description: TextView
    private lateinit var age: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        background = view.findViewById(R.id.ivBackgroundMovieDetails)
        date = view.findViewById(R.id.tvDate)
        title = view.findViewById(R.id.tvName)
        star = listOf(
            view.findViewById(R.id.ivStar),
            view.findViewById(R.id.ivStar1),
            view.findViewById(R.id.ivStar2),
            view.findViewById(R.id.ivStar3),
            view.findViewById(R.id.ivStar4)
        )
        description = view.findViewById(R.id.tvDescription)
        age = view.findViewById(R.id.tvAgeMovieDetails)

        (arguments?.getSerializable(MOVIE) as? MovieDto)?.let { movieDto ->
            background.load(movieDto.imageUrl)
            title.text = movieDto.title

            for (i in 0 until movieDto.rateScore) {
                star[i].load(R.drawable.ic_fill_star)
            }

            for (i in movieDto.rateScore until 5) {
                star[i].load(R.drawable.ic_empty_star)
            }

            description.text = movieDto.description
            age.text = movieDto.ageRestriction.toString() + "+"
        }
    }

    companion object {
        val TAG: String = FragmentMovieDetails::class.java.simpleName

        fun newInstance(movieDto: MovieDto) = FragmentMovieDetails().apply {
            arguments = bundleOf(MOVIE to movieDto)
        }
        val MOVIE: String = "MOVIE"
    }
}