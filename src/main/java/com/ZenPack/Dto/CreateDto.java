package com.ZenPack.Dto;

import com.ZenPack.model.Menu;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CreateDto {
    private Integer id;
    private String name;
    private String createdBy;
    private Date createdDate=new Date();
    private String updatedBy;
    private Date updatedTime=new Date();
    private Set<Menu> menus=new HashSet<>();
}
