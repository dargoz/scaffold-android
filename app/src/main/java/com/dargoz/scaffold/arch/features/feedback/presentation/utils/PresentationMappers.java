package com.dargoz.scaffold.arch.features.feedback.presentation.utils;

import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.presentation.models.FeedbackItemVM;
import com.dargoz.scaffold.arch.features.feedback.presentation.models.IssueVM;

import java.util.ArrayList;
import java.util.List;

public class PresentationMappers {

    public static IssueEntity toIssue(IssueVM issueVM) {
        return new IssueEntity(
                issueVM.getTitle(),
                "",
                issueVM.getActual(),
                issueVM.getExpected(),
                "",
                issueVM.getLabels()
        );
    }

    public static List<FeedbackItemVM> mapToFeedbackItemVMList(List<IssueEntity> issueEntities) {
        List<FeedbackItemVM> feedbackItemVMList = new ArrayList<>();
        for(IssueEntity issueEntity : issueEntities) {
            feedbackItemVMList.add(mapToFeedbackItemVM(issueEntity));
        }
        return feedbackItemVMList;
    }

    public static FeedbackItemVM mapToFeedbackItemVM(IssueEntity issueEntity) {
        FeedbackItemVM feedbackItemVM = new FeedbackItemVM();
        feedbackItemVM.setCreatedDate(issueEntity.getCreatedAt());
        feedbackItemVM.setTitle(issueEntity.getTitle());
        feedbackItemVM.setDescription(issueEntity.getDescription());
        return feedbackItemVM;
    }

    public static IssueVM mapToIssueVM(IssueEntity data) {
        IssueVM issueVM = new IssueVM();
        issueVM.setTitle(data.getTitle());
        return new IssueVM();
    }
}
