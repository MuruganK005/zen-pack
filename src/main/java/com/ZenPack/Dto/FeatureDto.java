package com.ZenPack.Dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FeatureDto {

    private Long featureId;
    private String featureName;
    private String featureUrl;
    private String createdBy;
    private Date createdTime;

}
