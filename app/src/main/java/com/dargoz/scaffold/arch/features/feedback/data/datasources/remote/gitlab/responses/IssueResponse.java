package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.responses;

import java.util.List;
import lombok.Data;

@Data
public class IssueResponse{
	private Object discussionLocked;
	private int upvotes;
	private References references;
	private int iid;
	private int mergeRequestsCount;
	private Links links;
	private String description;
	private String createdAt;
	private List<Object> assignees;
	private String title;
	private String type;
	private Object closedBy;
	private boolean hasTasks;
	private boolean subscribed;
	private Object serviceDeskReplyTo;
	private String updatedAt;
	private int projectId;
	private TimeStats timeStats;
	private int id;
	private String state;
	private boolean confidential;
	private Object closedAt;
	private Author author;
	private Object dueDate;
	private String issueType;
	private int downvotes;
	private int blockingIssuesCount;
	private List<String> labels;
	private Object movedToId;
	private Object milestone;
	private String webUrl;
	private int userNotesCount;
	private Object assignee;
	private TaskCompletionStatus taskCompletionStatus;
}