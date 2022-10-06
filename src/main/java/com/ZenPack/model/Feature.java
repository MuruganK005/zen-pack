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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    private Integer featureId;
    @Column(name = "feature_name")
    private String featureName;
    @Column(name = "feature_url")
    private String featureUrl;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_time")
    private Date createdTime=new Date();

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
