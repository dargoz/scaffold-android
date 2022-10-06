package com.dargoz.scaffold.arch.features.feedback.presentation.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dargoz.core.binding.BaseFragment;
import com.dargoz.scaffold.arch.databinding.FeedbackHistoryFragmentBinding;
import com.dargoz.scaffold.arch.features.feedback.presentation.adapters.FeedbackHistoryRVAdapter;
import com.dargoz.scaffold.arch.features.feedback.presentation.models.FeedbackItemVM;
import com.dargoz.scaffold.arch.features.feedback.presentation.presenters.FeedbackHistoryContract;
import com.dargoz.scaffold.arch.features.feedback.presentation.presenters.FeedbackHistoryPresenter;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FeedbackHistoryFragment extends BaseFragment<FeedbackHistoryFragmentBinding>
        implements FeedbackHistoryContract.View {

    @Inject
    FeedbackHistoryPresenter presenter;

    private final FeedbackHistoryRVAdapter adapter = new FeedbackHistoryRVAdapter();

    @Override
    protected View getViewBinding(@NonNull LayoutInflater inflater,
                                  @Nullable ViewGroup container,
                                  @Nullable Bundle savedInstanceState) {
        binding = FeedbackHistoryFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getSubmitHistory();
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onSuccess(List<FeedbackItemVM> feedbackItemVMList) {
        binding.feedbackHistoryEmptyTv
                .setVisibility(feedbackItemVMList.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.setFeedbackItemVMList(feedbackItemVMList);
        binding.feedbackHistoryRv.setAdapter(adapter);
    }

    @Override
    public void onError() {

    }
}