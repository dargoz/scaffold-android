package com.dargoz.scaffold.arch.core.binding;

import android.content.Context;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.dargoz.scaffold.arch.MainActivity;
import com.dargoz.scaffold.arch.R;

@SuppressWarnings("ALL")
public class BasePresenter<ViewContract> {
    protected ViewContract viewContract;

    public BasePresenter(Context context) {
        NavHostFragment navHostFragment = (NavHostFragment) ((MainActivity)context)
                .getSupportFragmentManager().findFragmentById(R.id.main_nav_host_fragment);
        this.viewContract = (ViewContract) navHostFragment.getChildFragmentManager().getFragments().get(0);
    }
}
