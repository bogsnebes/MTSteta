package com.bogsnebes.mts.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bogsnebes.mts.R
import com.bogsnebes.mts.ui.fragments.list_of_movies.FragmentListOfMovies
import com.bogsnebes.mts.ui.fragments.profile.FragmentProfile
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main),
    BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var bottomNavigationMenu: BottomNavigationView
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottomNavigationMenu = findViewById(R.id.bottomNavigationView)
        navController = Navigation.findNavController(this, R.id.container)
        bottomNavigationMenu.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, FragmentListOfMovies())
                .commit()
            R.id.profile -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, FragmentProfile())
                .commit()
        }
        return true
    }
}
