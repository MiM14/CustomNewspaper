package com.moaimar.custom_newspaper.features.rssmanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.rss_aggregator_2022.R
import com.example.rss_aggregator_2022.databinding.FragmentUserFormBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFormFragment : BottomSheetDialogFragment() {
    private var binding: FragmentUserFormBinding? = null

    private val viewModel by viewModels<UserFormViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserFormBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    private fun setupView() {
        binding?.apply {
            bottomsheetButtonCancel.setOnClickListener() {
                findNavController().navigateUp()
            }
            bottomsheetButtonSave.setOnClickListener() {
                viewModel.saveRss(
                    inputUrl.text.toString(),
                    inputName.text.toString()
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        val userFormSubscriber = Observer<UserFormViewModel.FormUiState> {
            showSnackBar(it.isSuccess)
            findNavController().navigateUp()
        }
        viewModel.formUiState.observe(this, userFormSubscriber)
    }

    private fun showSnackBar(isSuccess: Boolean) {
        Snackbar.make(
            (requireActivity()).findViewById<ViewGroup>(R.id.main_fragment_view),
            if (isSuccess) {
                R.string.added_record
            } else {
                R.string.error_added_record
            },
            Snackbar.LENGTH_SHORT
        ).show()
    }
}
