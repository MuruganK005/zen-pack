package com.ZenPack.Dto;

import com.ZenPack.model.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ZenPackDto {
    private Long id;
    private String name;
    private String createdBy;
    private Date createdDate=new Date();
    private String updatedBy;
    private Date updatedTime=new Date();
    private List<Menu> menus;
}
