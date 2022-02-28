package com.dargoz.scaffold.arch.features.feedback.data.utils;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.local.models.Issue;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.requests.IssueRequest;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.responses.IssueResponse;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataMappers {

    private DataMappers() {}


    public static IssueRequest mapToIssueRequest(IssueEntity issue) {
        return new IssueRequest(
                issue.getTitle(),
                issue.getDescription()
        );
    }

    public static Issue mapToIssue(IssueEntity issue) {
        Issue tempIssue = new Issue();
        tempIssue.setCreatedDate(issue.getCreatedAt());
        tempIssue.setTitle(issue.getTitle());
        tempIssue.setDesc(issue.getDescription());
        return tempIssue;
    }

    public static IssueEntity mapToIssueEntity(Issue issue) {
        return new IssueEntity(
                issue.getTitle(),
                issue.getDesc(),
                "",
                "",
                issue.getCreatedDate(),
                new ArrayList<>()
        );
    }

    public static IssueEntity mapToIssueEntity(IssueResponse issueResponse) {
        return new IssueEntity(
                issueResponse.getTitle(),
                issueResponse.getDescription(),
                "",
                "",
                issueResponse.getCreatedAt(),
                issueResponse.getLabels()
        );
    }

    public static List<IssueEntity> mapToIssueEntity(List<Issue> data) {
        List<IssueEntity> issueEntities = new ArrayList<>();
        for(Issue issue : data) {
            issueEntities.add(mapToIssueEntity(issue));
        }
        return issueEntities;
    }
}
