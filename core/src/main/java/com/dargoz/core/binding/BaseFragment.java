package com.dargoz.core.binding;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public abstract class BaseFragment<T> extends Fragment {
    protected T binding;

    protected void registerOnBackPressed(int navHostId, int actionId) {
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Log.d("DRG","handle back pressed");
                // Handle the back button event
                Navigation.findNavController(requireActivity(), navHostId).navigate(actionId);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = getViewBinding(inflater, container, savedInstanceState);
        if(binding == null) throw new NullPointerException("Don't Forget to Create View Binding");
        return view;
    }

    protected abstract View getViewBinding(@NonNull LayoutInflater inflater,
                                           @Nullable ViewGroup container,
                                           @Nullable Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
