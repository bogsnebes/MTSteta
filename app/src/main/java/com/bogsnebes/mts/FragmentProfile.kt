package com.bogsnebes.mts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FragmentProfile : Fragment() {
    private lateinit var recyclerCategory: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        recyclerCategory = view.findViewById(R.id.recyclerCategoryProfile)

        recyclerCategory.adapter = CategoryAdapter(categories, view.context)

        return view
    }

    companion object {
        val TAG: String = FragmentProfile::class.java.simpleName
        fun newInstance() = FragmentProfile()

        private val categories = listOf("боевики", "драмы", "комедии")
    }
}