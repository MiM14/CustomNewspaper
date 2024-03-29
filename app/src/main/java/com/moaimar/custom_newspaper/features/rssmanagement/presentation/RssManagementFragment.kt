package com.moaimar.custom_newspaper.features.rssmanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.moaimar.custom_newspaper.R
import com.moaimar.custom_newspaper.databinding.FragmentRssManagementBinding
import com.moaimar.custom_newspaper.features.rssmanagement.presentation.RssManagementFragmentDirections.Companion.actionManagementToUserForm
import com.moaimar.custom_newspaper.features.rssmanagement.presentation.adapter.RssManagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RssManagementFragment : Fragment() {
    private var binding: FragmentRssManagementBinding? = null
    private val managerAdapter = RssManagerAdapter()
    private val viewModel by viewModels<RssManagementViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssManagementBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    private fun setupView() {
        binding?.apply {
            rssSourceFeed.apply {
                adapter = managerAdapter
                layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                managerAdapter.setOnClick { url ->
                    viewModel.delete(url)
                    Snackbar.make(
                        (requireActivity()).findViewById<ViewGroup>(R.id.main_fragment_view),
                        R.string.success_delete,
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
            managementToolbar.apply {
                title = getString(R.string.manager_name)
                setOnMenuItemClickListener {
                    if (R.id.to_user_form == it.itemId) {
                        findNavController().navigate(
                            actionManagementToUserForm()
                        )
                    }
                    true
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.obtainRss()
    }

    private fun setupObservers() {
        val managerRssSubscriber = Observer<RssManagementViewModel.ManagerUiState> { uiState ->
            if (uiState.error != null) {
                uiState.error.let {
                    Snackbar.make(
                        (requireActivity()).findViewById<ViewGroup>(R.id.main_fragment_view),
                        R.string.unk_error,
                        Snackbar.LENGTH_LONG
                    )
                }
            } else {
                managerAdapter.setDataItems(uiState.managerFeed)
            }
        }
        viewModel.managerUiState.observe(viewLifecycleOwner, managerRssSubscriber)
    }


}