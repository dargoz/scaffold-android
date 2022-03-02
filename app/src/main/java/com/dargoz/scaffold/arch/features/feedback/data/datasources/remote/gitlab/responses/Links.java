package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.responses;

import lombok.Data;

@Data
public class Links{
	private String notes;
	private String self;
	private String awardEmoji;
	private String project;
}