package com.ZenPack.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "feature")
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feature_id")
    private Long featureId;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private Date createdTime=new Date();
    @Column(name = "updated_time")
    private Date updatedTime=new Date();

}
