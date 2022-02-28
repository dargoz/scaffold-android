package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.responses;

import lombok.Data;

@Data
public class TaskCompletionStatus{
	private int count;
	private int completedCount;
}