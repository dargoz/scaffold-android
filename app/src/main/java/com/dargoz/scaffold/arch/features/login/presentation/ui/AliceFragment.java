package com.dargoz.scaffold.arch.features.login.presentation.ui;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dargoz.core.binding.BaseFragment;
import com.dargoz.scaffold.arch.R;
import com.dargoz.scaffold.arch.databinding.AliceFragmentBinding;


public class AliceFragment extends BaseFragment<AliceFragmentBinding> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Log.d("DRG","Alice back pressed");
                // Handle the back button event
                Navigation.findNavController(requireActivity(), R.id.main_nav_host_fragment).navigate(R.id.action_back_alice);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    protected View getViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AliceFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.aliceToBobBtn.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_aliceFragment_to_bobFragment));
    }
}