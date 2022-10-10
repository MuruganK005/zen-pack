package com.ZenPack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private List<SubMenu> subMenus;

}
