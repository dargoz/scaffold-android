package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.responses;

import lombok.Data;

@Data
public class TimeStats{
	private int timeEstimate;
	private int totalTimeSpent;
	private Object humanTimeEstimate;
	private Object humanTotalTimeSpent;
}