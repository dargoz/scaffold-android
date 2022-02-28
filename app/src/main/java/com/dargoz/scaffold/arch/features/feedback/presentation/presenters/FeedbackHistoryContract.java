package com.dargoz.scaffold.arch.features.feedback.presentation.presenters;

import com.dargoz.scaffold.arch.features.feedback.presentation.models.FeedbackItemVM;

import java.util.List;

public interface FeedbackHistoryContract {

    interface View {
        void onLoading();
        void onSuccess(List<FeedbackItemVM> feedbackItemVMList);
        void onError();
    }

    interface Presenter {
        void getSubmitHistory();
    }

}
