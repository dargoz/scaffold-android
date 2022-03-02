package com.dargoz.scaffold.arch.features.feedback.presentation.presenters;

import com.dargoz.scaffold.arch.features.feedback.presentation.models.IssueVM;

public interface FeedbackContract {

    interface View { // UI State
        void onLoading();
        void onSuccess(IssueVM issueVM);
        void onError(String errorMessage);
    }

    interface Presenter {
        void submitFeedback(String title);
        void onTitleChange(String text);
        void onDescriptionChange(String text);
    }

}
