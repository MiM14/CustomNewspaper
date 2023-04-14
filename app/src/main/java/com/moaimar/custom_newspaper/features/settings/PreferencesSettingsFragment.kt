package com.moaimar.custom_newspaper.features.settings

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.moaimar.custom_newspaper.BuildConfig
import com.moaimar.custom_newspaper.R

class PreferencesSettingsFragment : PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference_fragment_settings, rootKey)
        setUpSettings()
    }

    private fun setUpSettings() {
        val pref: Preference? = findPreference("app_version")
        pref?.summary = BuildConfig.VERSION_NAME
    }
}