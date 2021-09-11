package com.bogsnebes.mts.ui.fragments.movie_details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bogsnebes.mts.MainViewModel
import com.bogsnebes.mts.R
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.ui.fragments.CategoryAdapter
import com.bogsnebes.mts.ui.fragments.list_of_movies.FragmentListOfMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentMovieDetails : Fragment(R.layout.fragment_movie_details) {

    private lateinit var background: ImageView
    private lateinit var date: TextView
    private lateinit var title: TextView
    private lateinit var star: List<ImageView>
    private lateinit var description: TextView
    private lateinit var age: TextView
    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
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
        recyclerView = view.findViewById(R.id.rvActors)

        (arguments?.getSerializable(FragmentListOfMovies.MOVIE_OPEN_KEY) as? MovieDto)?.let { movieDto ->
            background.load("https://image.tmdb.org/t/p/original/" + movieDto.imageUrl)
            title.text = movieDto.title

            for (i in 0 until movieDto.rateScore.toInt() / 2) {
                star[i].load(R.drawable.ic_fill_star)
            }

            for (i in movieDto.rateScore.toInt() / 2 until 5) {
                star[i].load(R.drawable.ic_empty_star)
            }

            description.text = movieDto.description
            if (movieDto.ageRestriction)
                age.text = "18+"
            else
                age.text = "0+"

            lifecycleScope.launch(Dispatchers.IO) {
                movieDto.id?.let { mainViewModel.getActors(it.toInt()) }
                withContext(Dispatchers.Main) {
                    mainViewModel.resultActors.observe(viewLifecycleOwner, Observer {
                        recyclerView.adapter = ActorsAdapter(view.context, it)
                    })
                }
            }
        }
    }


    companion object {
        val TAG: kotlin.String = FragmentMovieDetails::class.java.simpleName

        fun newInstance(movieDto: MovieDto) = FragmentMovieDetails().apply {
            arguments = bundleOf(MOVIE to movieDto)
        }

        const val MOVIE: kotlin.String = "MOVIE"
    }
}