package com.dargoz.scaffold.arch.features.feedback.presentation.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dargoz.scaffold.arch.R;
import com.dargoz.scaffold.arch.core.binding.BaseFragment;
import com.dargoz.scaffold.arch.databinding.FeedbackFragmentBinding;
import com.dargoz.scaffold.arch.features.feedback.presentation.presenters.FeedbackContract;
import com.dargoz.scaffold.arch.features.feedback.presentation.presenters.FeedbackPresenter;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FeedbackFragment extends BaseFragment<FeedbackFragmentBinding>
        implements FeedbackContract.View {

    @Inject
    FeedbackPresenter feedbackPresenter;

    @Override
    protected View getViewBinding(@NonNull LayoutInflater inflater,
                                  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FeedbackFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.feedbackSubmitButton.setOnClickListener(v ->
                feedbackPresenter.submitFeedback(
                        binding.feedbackTitleEditText.getText().toString()
                ));
        binding.feedbackHistoryTextView.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_feedbackFragment_to_feedbackHistoryFragment));
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onSuccess() {
        Toast.makeText(requireActivity(), "Success submit feedback", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {

    }
}