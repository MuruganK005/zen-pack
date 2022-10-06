package com.ZenPack.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zen_pack")
public class ZenPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "zen_pack_name")
    private String name;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate=new Date();
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_time")
    private Date updatedTime=new Date();
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "zenPack")
    private List<Menu> menus=new ArrayList<>();

}
