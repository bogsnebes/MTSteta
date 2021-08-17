package com.bogsnebes.mts.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bogsnebes.mts.MainViewModel
import com.bogsnebes.mts.R
import com.bogsnebes.mts.ui.fragments.CategoryAdapter

class FragmentProfile : Fragment() {
    private lateinit var recyclerCategory: RecyclerView
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getProfileCategories()

        recyclerCategory = view.findViewById(R.id.rvCategoryProfile)
        mainViewModel.resultCategory.observe(viewLifecycleOwner, Observer {
            recyclerCategory.adapter = CategoryAdapter(view.context, it)
        })

    }

    companion object {
        val TAG: String = FragmentProfile::class.java.simpleName

        fun newInstance() = FragmentProfile()
    }
}