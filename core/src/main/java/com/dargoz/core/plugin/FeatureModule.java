package com.dargoz.core.plugin;

import androidx.fragment.app.Fragment;

public interface FeatureModule {

    Fragment getFragment();

    String getTitle();
}
