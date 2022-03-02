package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.responses;

import lombok.Data;

@Data
public class TaskCompletionStatus{
	private int count;
	private int completedCount;
}