package com.moaimar.custom_newspaper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moaimar.custom_newspaper.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setUpNavigation()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setUpNavigation() {
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            when (it.itemId) {
                R.id.to_rss_feed_item -> navigateToFeed()
                R.id.to_rss_manager_item -> navigateToManagement()
                R.id.to_your_profile_item -> navigateToProfile()
            }
            true
        }
    }

    private fun navigateToFeed() {
        findNavController(R.id.main_fragment_view).navigate(NavGraphDirections.toFeed())
    }

    private fun navigateToManagement() {
        findNavController(R.id.main_fragment_view).navigate(NavGraphDirections.toManagement())
    }

    private fun navigateToProfile() {
        findNavController(R.id.main_fragment_view).navigate(NavGraphDirections.toProfile())
    }

}