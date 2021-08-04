package com.bogsnebes.mts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bogsnebes.mts.data.movies.CategoriesDataSource

class FragmentListOfMovies : Fragment() {

    private lateinit var recyclerMovie: RecyclerView
    private lateinit var recyclerCategory: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerMovie = view.findViewById(R.id.rvMovie)
        recyclerCategory = view.findViewById(R.id.rvCategory)

        recyclerCategory.adapter = CategoryAdapter(view.context, categoriesData.getCategories())

        recyclerMovie.layoutManager = GridLayoutManager(view.context, 2)
        recyclerMovie.adapter = MyMoviesAdapter(view.context, MainActivity.movieData.getMovies()) {
            parentFragmentManager.setFragmentResult(MOVIE_OPEN_KEY, bundleOf(MOVIE_OPEN_KEY to it))
        }
    }

    companion object {
        val TAG: String = FragmentListOfMovies::class.java.simpleName

        fun newInstance() = FragmentListOfMovies()
        internal const val MOVIE_OPEN_KEY: String = "MOVIE_OPEN_KEY"
        val categoriesData = CategoriesDataSource()
    }
}