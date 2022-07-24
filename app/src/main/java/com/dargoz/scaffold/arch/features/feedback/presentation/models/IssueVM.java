package com.dargoz.scaffold.arch.features.feedback.presentation.models;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IssueVM {

    private int id;
    private String title;
    private String actual;
    private String expected;
    private List<String> labels;

}
