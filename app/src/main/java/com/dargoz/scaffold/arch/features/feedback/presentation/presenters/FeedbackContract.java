package com.dargoz.scaffold.arch.features.feedback.presentation.presenters;

public interface FeedbackContract {

    interface View {
        void onLoading();
        void onSuccess();
        void onError();
    }

    interface Presenter {
        void submitFeedback(String title);
    }

}
