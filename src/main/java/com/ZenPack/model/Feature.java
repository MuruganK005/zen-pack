package com.ZenPack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "feature")
@NoArgsConstructor
@AllArgsConstructor
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feature_id")
    private Long featureId;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "feature_url")
    private String featureUrl;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private Date createdTime=new Date();

    @Column(name = "updated_time")
    private Date updatedTime=new Date();

}
