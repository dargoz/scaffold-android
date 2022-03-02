package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.responses;

import lombok.Data;

@Data
public class References{
	private String jsonMemberShort;
	private String relative;
	private String full;
}