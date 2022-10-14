package com.ZenPack.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZenPackDto {
    private Long zenPackId;
    private String name;
    private String createdBy;
    private Long createdDate;
    private String updatedBy;
    private Long updatedTime;
    private String jsonData;
    private List<MenuDto> menus;
    private List<FeatureDto> features;
}