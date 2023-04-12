package com.moaimar.custom_newspaper.features.rssfeed.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.moaimar.custom_newspaper.databinding.FragmentRssFeedBinding
import com.moaimar.custom_newspaper.features.rssfeed.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RssFeedFragment : Fragment() {

    var binding: FragmentRssFeedBinding? = null
    private val viewModel by viewModels<RssFeedViewModel>()

    @Inject
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssFeedBinding.inflate(inflater)
        setUpView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        viewModel.getNewsList()
    }

    private fun setUpView() {
        binding?.apply {
            newsList.apply {
                adapter = newsAdapter
                    layoutManager = LinearLayoutManager(
                    requireContext(), LinearLayoutManager.VERTICAL, false
                )
                //skeleton = applySkeleton(R.layout.item_character_list, 4)
                //swipeRefreshLayout.setOnRefreshListener {
                // viewModel.refreshFeed()
                // }

            }
        }
    }

    private fun setUpObserver() {
        val characterListObserver =
            Observer<RssFeedViewModel.UiState> { uiState ->
                if (uiState.isLoading) {
                    //TODO
                } else {
                    //TODO
                    //binding?.swipeRefreshLayout?.isRefreshing = false
                    if (uiState.error != null) {
                        //errorHandler(uiState.error)
                    } else {
                        newsAdapter.submitList(uiState.news)
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, characterListObserver)
    }
}