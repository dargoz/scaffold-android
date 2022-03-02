package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueRequest {

    String title;
    String description;
}
