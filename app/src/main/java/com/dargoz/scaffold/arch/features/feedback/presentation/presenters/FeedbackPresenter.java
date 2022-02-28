package com.dargoz.scaffold.arch.features.feedback.presentation.presenters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;


import com.dargoz.scaffold.arch.core.binding.BasePresenter;
import com.dargoz.scaffold.arch.core.models.Result;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.usecases.BugReportUseCase;
import com.dargoz.scaffold.arch.features.feedback.domain.usecases.SaveFeedbackHistoryUseCase;
import com.dargoz.scaffold.arch.features.feedback.presentation.models.IssueVM;
import com.dargoz.scaffold.arch.features.feedback.presentation.utils.PresentationMappers;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;
import io.reactivex.subscribers.DisposableSubscriber;

public class FeedbackPresenter extends BasePresenter<FeedbackContract.View>
        implements FeedbackContract.Presenter {
    private final BugReportUseCase bugReportUseCase;
    private final SaveFeedbackHistoryUseCase saveFeedbackHistoryUseCase;

    public IssueVM issueVM = new IssueVM();

    @Inject
    public FeedbackPresenter(
            @ActivityContext Context context,
            BugReportUseCase bugReportUseCase,
            SaveFeedbackHistoryUseCase saveFeedbackHistoryUseCase) {
        super(context);
        this.bugReportUseCase = bugReportUseCase;
        this.saveFeedbackHistoryUseCase = saveFeedbackHistoryUseCase;
    }

    @SuppressLint("CheckResult")
    @Override
    public void submitFeedback(String title) {
        viewContract.onLoading();
        issueVM.setTitle(title);
        bugReportUseCase.execute(PresentationMappers.toIssue(issueVM), result -> {
            Log.d("DRG", "success submit result :: " + result.getData());
            viewContract.onSuccess();
            saveSubmitHistory(result);

        });
    }

    @SuppressLint("CheckResult")
    private void saveSubmitHistory(Result<IssueEntity> data) {
        saveFeedbackHistoryUseCase.execute(data.getData(), result -> {
            Log.d("DRG", "success save feedback history");
        });
    }
}
