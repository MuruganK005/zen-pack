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
    @Column(name = "id")
    private Integer id;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "created_time")
    private Date createdTime=new Date();
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "parent_menu_id")
    private Integer parentMenuId;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "menu")
    private List<Feature> features=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "zen_pack_id")
    private ZenPack zenPack;


}
