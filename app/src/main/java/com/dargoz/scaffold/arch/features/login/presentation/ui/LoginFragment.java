package com.dargoz.scaffold.arch.features.login.presentation.ui;



import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dargoz.core.binding.BaseFragment;
import com.dargoz.core.models.Result;
import com.dargoz.scaffold.arch.databinding.LoginFragmentBinding;
import com.dargoz.scaffold.arch.features.login.presentation.models.LoginModel;
import com.dargoz.scaffold.arch.features.login.presentation.viewmodels.LoginViewModel;

import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment<LoginFragmentBinding> {
    LoginViewModel loginViewModel;

    @Override
    protected View getViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                  @Nullable Bundle savedInstanceState) {
        binding = LoginFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getState().observe(getViewLifecycleOwner(), onStateChange);
        binding.loginSubmitButton.setOnClickListener(
                v->loginViewModel.requestAuth(
                        Objects.requireNonNull(binding.loginUsernameEditText.getText()).toString(),
                        Objects.requireNonNull(binding.loginPassEditText.getText()).toString())
        );
    }

    private final Observer<Result<LoginModel>> onStateChange = result -> {
        Log.d("DRG","result : " + result.getData());
    };
}