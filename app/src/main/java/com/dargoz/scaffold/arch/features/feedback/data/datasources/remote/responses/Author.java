package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.responses;

import lombok.Data;

@Data
public class Author{
	private String avatarUrl;
	private String webUrl;
	private String name;
	private int id;
	private String state;
	private String username;
}