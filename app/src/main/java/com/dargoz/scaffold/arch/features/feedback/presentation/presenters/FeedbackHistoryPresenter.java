package com.dargoz.scaffold.arch.features.feedback.presentation.presenters;

import android.content.Context;
import android.os.Looper;
import android.util.Log;

import com.dargoz.scaffold.arch.core.binding.BasePresenter;
import com.dargoz.scaffold.arch.core.usecase.RxUseCase;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.usecases.GetSubmitHistoryUseCase;
import com.dargoz.scaffold.arch.features.feedback.presentation.utils.PresentationMappers;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class FeedbackHistoryPresenter extends BasePresenter<FeedbackHistoryContract.View>
        implements FeedbackHistoryContract.Presenter {
    private final GetSubmitHistoryUseCase getSubmitHistoryUseCase;

    @Inject
    public FeedbackHistoryPresenter(@ActivityContext Context context,
                                    GetSubmitHistoryUseCase submitHistoryUseCase) {
        super(context);
        this.getSubmitHistoryUseCase = submitHistoryUseCase;
    }

    @Override
    public void getSubmitHistory() {
        getSubmitHistoryUseCase
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
                .execute(0, new DisposableSubscriber<List<IssueEntity>>() {
                    @Override
                    public void onNext(List<IssueEntity> issueEntity) {
                        Log.d("DRG", this.getClass().getSimpleName() + " get Submit history : " + issueEntity.toString());
                        viewContract.onSuccess(
                                PresentationMappers.mapToFeedbackItemVMList(issueEntity));
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("DRG", "onError : " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void destroy() {
        getSubmitHistoryUseCase.dispose();
    }
}
