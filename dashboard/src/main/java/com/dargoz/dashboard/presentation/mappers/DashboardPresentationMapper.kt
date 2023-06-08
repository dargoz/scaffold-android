package com.dargoz.dashboard.presentation.mappers

import com.dargoz.core.mediator.Section
import com.dargoz.core.plugin.FeatureModule
import com.dargoz.example.presentation.ui.DefaultModule
import com.dargoz.example.presentation.ui.ExampleModule

fun Section.toModule(): FeatureModule {
    return if (sectionName == "example") ExampleModule(title)
    else DefaultModule(title)
}