package com.bogsnebes.mts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentListOfMovies: Fragment() {

    private lateinit var recyclerMovie: RecyclerView
    private lateinit var recyclerCategory: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_of_movies, container, false)
        recyclerMovie = view.findViewById(R.id.recyclerMovie)!!
        recyclerCategory = view.findViewById(R.id.recyclerCategory)

        recyclerCategory.hasFixedSize()
        val categoryes = listOf<String>("боевики", "драмы", "комедии", "артхаус", "мелодрамы")
        recyclerCategory.adapter = CategoryAdapter(categoryes, view.context)

        recyclerMovie.layoutManager = GridLayoutManager(view.context, 2)
        recyclerMovie.adapter = MyMoviesAdapter(MainActivity.movieData.getMovies(), view.context) {
            parentFragmentManager.setFragmentResult(MOVIE_OPEN_KEY, bundleOf(MOVIE_OPEN_KEY to it))
        }

        return view
    }

    companion object {
        val TAG: String = FragmentListOfMovies::class.java.simpleName
        fun newInstance() = FragmentListOfMovies()
        internal const val MOVIE_OPEN_KEY: String = "Movie open key"
    }
}