package com.example.instagramcloneapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.instagramcloneapp.Fragments.NotificationsFragment
import com.example.instagramcloneapp.Fragments.ProfileFragment
import com.example.instagramcloneapp.Fragments.SearchFragment
import com.example.instagramcloneapp.Fragments.homeFragment

class MainActivity : AppCompatActivity() {
    internal var selectedFragment: Fragment? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                navToFragment(homeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                navToFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_add_post -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                navToFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notifications -> {
                navToFragment(NotificationsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navToFragment(homeFragment())
    }
    private fun navToFragment(fragment: Fragment){
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragments_container, fragment)
        fragmentTrans.commit()
    }
}
