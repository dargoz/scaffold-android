package com.dargoz.core.binding;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;


@SuppressWarnings("ALL")
public abstract class BasePresenter<ViewContract> {
    protected ViewContract viewContract;

    public BasePresenter(Context context) {
        NavHostFragment navHostFragment = (NavHostFragment) ((AppCompatActivity) context)
                .getSupportFragmentManager().findFragmentById(getNavHostId());
        this.viewContract = (ViewContract) navHostFragment.getChildFragmentManager().getFragments().get(0);
    }

    /**
     * nav host fragment id
     */
    public abstract int getNavHostId();

    /**
     * unsubscribe RxUseCase here
     */
    public abstract void destroy();
}
