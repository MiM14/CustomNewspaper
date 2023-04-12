package com.moaimar.custom_newspaper.features.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.moaimar.custom_newspaper.R
import com.moaimar.custom_newspaper.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    var binding: FragmentSettingsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater)
        setUpView()
        return binding?.root
    }

    private fun setUpView() {
        binding?.apply {
            toolbar.mainToolbar.title = getString(R.string.settings_name)
        }
    }
}