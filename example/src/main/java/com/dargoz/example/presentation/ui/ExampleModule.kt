package com.dargoz.example.presentation.ui

import androidx.fragment.app.Fragment
import com.dargoz.core.plugin.FeatureModule

class ExampleModule(private val title: String) : FeatureModule {
    override fun getFragment(): Fragment {
        return WidgetFragment()
    }

    override fun getTitle(): String {
        return title
    }
}