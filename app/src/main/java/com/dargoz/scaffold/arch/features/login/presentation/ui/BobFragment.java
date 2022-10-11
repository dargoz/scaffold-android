package com.dargoz.scaffold.arch.features.login.presentation.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dargoz.core.binding.BaseFragment;
import com.dargoz.scaffold.arch.R;
import com.dargoz.scaffold.arch.databinding.BobFragmentBinding;


public class BobFragment extends BaseFragment<BobFragmentBinding> {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerOnBackPressed(R.id.main_nav_host_fragment, R.id.action_back_bob);
    }

    @Override
    protected View getViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BobFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}