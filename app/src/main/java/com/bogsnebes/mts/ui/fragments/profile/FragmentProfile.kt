package com.bogsnebes.mts.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bogsnebes.mts.MainViewModel
import com.bogsnebes.mts.ui.fragments.CategoryAdapter
import com.bogsnebes.mts.R
import com.bogsnebes.mts.data.movies.CategoriesDataSource

class FragmentProfile : Fragment() {
    private lateinit var recyclerCategory: RecyclerView
    private lateinit var mViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerCategory = view.findViewById(R.id.rvCategoryProfile)

        recyclerCategory.adapter = CategoryAdapter(view.context, mViewModel.getProfileCategories())
    }

    companion object {
        val TAG: String = FragmentProfile::class.java.simpleName

        fun newInstance() = FragmentProfile()
    }
}