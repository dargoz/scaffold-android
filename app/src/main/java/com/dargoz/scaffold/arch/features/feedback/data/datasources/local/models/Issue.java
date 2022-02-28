package com.dargoz.scaffold.arch.features.feedback.data.datasources.local.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Issue extends RealmObject {

    @PrimaryKey
    private int id;

    private String createdDate;
    private String title;
    private String desc;

}
