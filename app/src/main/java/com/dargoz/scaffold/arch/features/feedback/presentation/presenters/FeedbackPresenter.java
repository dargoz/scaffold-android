package com.dargoz.scaffold.arch.features.feedback.presentation.presenters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.util.Log;


import com.dargoz.core.binding.BasePresenter;
import com.dargoz.core.models.Result;
import com.dargoz.core.usecase.RxUseCase;
import com.dargoz.scaffold.arch.R;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.usecases.BugReportUseCase;
import com.dargoz.scaffold.arch.features.feedback.domain.usecases.SaveFeedbackHistoryUseCase;
import com.dargoz.scaffold.arch.features.feedback.presentation.models.IssueVM;
import com.dargoz.scaffold.arch.features.feedback.presentation.utils.PresentationMappers;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
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
        bugReportUseCase
                .setRxScheduler(new RxUseCase.RxScheduler() {
                    @Override
                    public Scheduler subscribeOnScheduler() {
                        return Schedulers.io();
                    }

                    @Override
                    public Scheduler observeOnScheduler() {
                        return AndroidSchedulers.mainThread();
                    }
                })
                .execute(PresentationMappers.toIssue(issueVM), result -> {
                    Log.d("DRG", "success submit result :: " + result.getData());
                    viewContract.onSuccess(PresentationMappers.mapToIssueVM(result.getData()));
                    saveSubmitHistory(result);

                });
    }

    @Override
    public void onTitleChange(String text) {
        //TODO : define your logic here
    }

    @Override
    public void onDescriptionChange(String text) {
        //TODO : define your logic here
    }

    @SuppressLint("CheckResult")
    private void saveSubmitHistory(Result<IssueEntity> data) {
        saveFeedbackHistoryUseCase
                .setRxScheduler(new RxUseCase.RxScheduler() {
                    @Override
                    public Scheduler subscribeOnScheduler() {
                        return AndroidSchedulers.from(Looper.getMainLooper());
                    }

                    @Override
                    public Scheduler observeOnScheduler() {
                        return AndroidSchedulers.mainThread();
                    }
                })
                .execute(data.getData(), result ->
                        Log.d("DRG", "success save feedback history"));
    }

    @Override
    public int getNavHostId() {
        return R.id.main_nav_host_fragment;
    }

    @Override
    public void destroy() {
        bugReportUseCase.dispose();
        saveFeedbackHistoryUseCase.dispose();
    }
}
