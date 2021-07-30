/*
package com.bogsnebes.mts

import androidx.fragment.app.Fragment
import com.bogsnebes.mts.R
import com.bogsnebes.mts.FragmentListOfMovies
import com.bogsnebes.mts.FragmentMovieDetails


enum class BottomNavigationPosition(val position: Int, val id: Int) {
    FIRST(0, R.id.),
    SECOND(1, R.id.second)
}
fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.FIRST.id -> BottomNavigationPosition.FIRST
    BottomNavigationPosition.SECOND.id -> BottomNavigationPosition.SECOND
    else -> BottomNavigationPosition.FIRST
}

fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.FIRST -> FirstFragment.newInstance()
    BottomNavigationPosition.SECOND -> SecondFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.FIRST -> FirstFragment.TAG
    BottomNavigationPosition.SECOND -> SecondFragment.TAG
}*/
