package com.dargoz.scaffold.arch.features.feedback.domain.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueEntity {

    int iid;
    String title;
    String description;
    String actual;
    String expected;
    String createdAt;
    List<String> labels;

}
