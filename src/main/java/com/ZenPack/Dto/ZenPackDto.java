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
    private Date createdDate;
    private String updatedBy;
    private Date updatedTime;
    private List<MenuDto> menus;
}