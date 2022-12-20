package com.moaimar.rss_aggregator_2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.rss_aggregator_2022.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


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

    private fun setUpNavigation(){
        findViewById<BottomNavigationView>(com.example.rss_aggregator_2022.R.id.bottom_navigation).setOnItemSelectedListener {
            when(it.itemId){
                com.example.rss_aggregator_2022.R.id.to_rss_feed_item -> navigateToFeed()
                com.example.rss_aggregator_2022.R.id.to_rss_manager_item -> navigateToManagement()
                com.example.rss_aggregator_2022.R.id.to_your_profile_item -> navigateToProfile()
            }
            true
        }
    }
    private fun navigateToFeed(){
        findNavController(com.example.rss_aggregator_2022.R.id.main_fragment_view).navigate(NavGraphDirections.toFeed())
    }
    private fun navigateToManagement(){
        findNavController(com.example.rss_aggregator_2022.R.id.main_fragment_view).navigate(NavGraphDirections.toManagement())
    }
    private fun navigateToProfile(){
        findNavController(com.example.rss_aggregator_2022.R.id.main_fragment_view).navigate(NavGraphDirections.toProfile())
    }

}