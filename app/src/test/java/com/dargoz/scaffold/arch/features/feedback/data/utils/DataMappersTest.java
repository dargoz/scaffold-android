package com.dargoz.scaffold.arch.features.feedback.data.utils;

import static org.junit.Assert.*;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.local.models.Issue;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.requests.IssueRequest;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.responses.IssueResponse;
import com.dargoz.scaffold.arch.features.feedback.di.NetworkModule;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataMappersTest {
    private final IssueEntity issueResult = new IssueEntity(
            "[BUG]",
            "✔️ Actual\nerror❌ Expected\ntidak error",
            "",
            "",
            "2022-02-27T17:00:32.967Z",
            new ArrayList<>());

    @Before
    public void setUp() {
    }

    @Test
    public void mapToIssueRequest() {
        IssueRequest actual = DataMappers.mapToIssueRequest(issueResult);
        IssueRequest expected = new IssueRequest(
                "[BUG]",
                "✔️ Actual\nerror❌ Expected\ntidak error"
        );
        assertEquals(expected, actual);
    }

    @Test
    public void mapToIssue() {
        Issue actual = DataMappers.mapToIssue(issueResult);
        Issue expected = new Issue();
        expected.setTitle(issueResult.getTitle());
        expected.setDesc(issueResult.getDescription());
        expected.setCreatedDate(issueResult.getCreatedAt());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getDesc(), actual.getDesc());
        assertEquals(expected.getCreatedDate(), actual.getCreatedDate());
    }

    @Test
    public void mapIssueResponseToIssueEntity() {
        IssueResponse response = NetworkModule.gson.fromJson(
                DummyResponse.createIssueResponse, IssueResponse.class);
        IssueEntity actual = DataMappers.mapToIssueEntity(response);
        assertEquals(response.getCreatedAt(), actual.getCreatedAt());
    }

    @Test
    public void testMapIssueToIssueEntity() {
        Issue issue = new Issue();
        issue.setTitle("test");
        issue.setDesc("my desc");
        issue.setCreatedDate("2022-02-05T08:09:45.068Z");
        IssueEntity actual = DataMappers.mapToIssueEntity(issue);
        assertEquals(issue.getTitle(), actual.getTitle());
        assertEquals(issue.getDesc(), actual.getDescription());
        assertEquals(issue.getCreatedDate(), actual.getCreatedAt());
    }

    @Test
    public void testMapToListIssueEntity() {
        List<Issue> issueList = new ArrayList<>();
        List<IssueEntity> actual = DataMappers.mapToIssueEntity(issueList);
        assertEquals(issueList.size(), actual.size());
    }
}