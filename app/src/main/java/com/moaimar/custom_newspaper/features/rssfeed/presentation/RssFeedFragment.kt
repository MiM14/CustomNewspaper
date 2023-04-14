package com.moaimar.custom_newspaper.features.rssfeed.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.moaimar.custom_newspaper.R
import com.moaimar.custom_newspaper.databinding.FragmentRssFeedBinding
import com.moaimar.custom_newspaper.features.rssfeed.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RssFeedFragment : Fragment() {

    private var binding: FragmentRssFeedBinding? = null
    private val viewModel by viewModels<RssFeedViewModel>()

    private var skeleton: Skeleton? = null

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
                skeleton = applySkeleton(R.layout.item_rss_feed, 4)
                swipeRefreshLayout.setOnRefreshListener {
                    viewModel.refreshFeed()
                }
                toolbar.mainToolbar.title = getString(R.string.feed_name)

            }
        }
    }

    private fun setUpObserver() {
        val characterListObserver =
            Observer<RssFeedViewModel.UiState> { uiState ->
                if (uiState.isLoading) {
                    skeleton?.showSkeleton()
                } else {
                    skeleton?.showOriginal()
                    binding?.swipeRefreshLayout?.isRefreshing = false
                    if (uiState.error != null) {
                        //TODO
                    } else {
                        newsAdapter.submitList(uiState.news)
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, characterListObserver)
    }
}