package com.ZenPack.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "created_time")
    private Date createdTime=new Date();

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "parent_menu_id")
    private String parentMenuId;

/*
   @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   @JoinColumn(name = "menu_name")
    private List<Menu> subMenus;
*/


   @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   @JoinColumn(name = "menu_id")
    private List<Feature> features;



}
