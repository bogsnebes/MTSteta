package com.bogsnebes.mts.ui.fragments.list_of_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bogsnebes.mts.MainViewModel
import com.bogsnebes.mts.R
import com.bogsnebes.mts.ui.MainActivity
import com.bogsnebes.mts.ui.fragments.CategoryAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentListOfMovies : Fragment() {

    private lateinit var recyclerMovie: RecyclerView
    private lateinit var recyclerCategory: RecyclerView
    private lateinit var swipeToRefresh: SwipeRefreshLayout
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeToRefresh = view.findViewById(R.id.strRvMovie)

        lifecycleScope.launch {
            mainViewModel.getCategories()
            mainViewModel.getMovies()
            withContext(Dispatchers.Main) {
                recyclerMovie = view.findViewById(R.id.rvMovie)
                recyclerCategory = view.findViewById(R.id.rvCategory)

                mainViewModel.resultCategory.observe(viewLifecycleOwner, Observer {
                    recyclerCategory.adapter = CategoryAdapter(view.context, it)
                })

                recyclerMovie.layoutManager = GridLayoutManager(view.context, 2)
                mainViewModel.resultMovies.observe(viewLifecycleOwner, Observer {
                    recyclerMovie.adapter = MyMoviesAdapter(view.context, it) {
                        val bundle = Bundle()
                        bundle.putSerializable(MOVIE_OPEN_KEY, it)
                        (activity as MainActivity).navController.navigate(
                            R.id.action_fragmentListOfMovies_to_fragmentMovieDetails,
                            bundle
                        )
                    }
                })
            }
        }

        swipeToRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                mainViewModel.getCategories()
                mainViewModel.getMoviesOnline()
                Thread.sleep(2000L)
                withContext(Dispatchers.Main) {
                    recyclerMovie = view.findViewById(R.id.rvMovie)
                    recyclerCategory = view.findViewById(R.id.rvCategory)

                    mainViewModel.resultCategory.observe(viewLifecycleOwner, Observer {
                        recyclerCategory.adapter = CategoryAdapter(view.context, it)
                    })

                    recyclerMovie.layoutManager = GridLayoutManager(view.context, 2)
                    mainViewModel.resultMovies.observe(viewLifecycleOwner, Observer {
                        recyclerMovie.adapter = MyMoviesAdapter(view.context, it) {
                            val bundle = Bundle()
                            bundle.putSerializable(MOVIE_OPEN_KEY, it)
                            (activity as MainActivity).navController.navigate(
                                R.id.action_fragmentListOfMovies_to_fragmentMovieDetails,
                                bundle
                            )
                        }
                    })
                    swipeToRefresh.isRefreshing = false
                }
            }
        }
    }

    companion object {
        val TAG: String = FragmentListOfMovies::class.java.simpleName

        fun newInstance() = FragmentListOfMovies()
        internal const val MOVIE_OPEN_KEY: String = "MOVIE_OPEN_KEY"
    }
}