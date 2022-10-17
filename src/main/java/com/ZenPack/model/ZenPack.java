package com.ZenPack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.JsonObject;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zen_pack")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZenPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zen_pack_id")
    private Long zenPackId;

    @Column(name = "zen_pack_name")
    private String name;

    @Column(name = "json_data",length = 50000)
    private String jsonData;

    @Column(name = "created_date")
    private Date updatedTime= new Date();

    @Column(name = "updated_time")
    private Date createdDate =new Date();

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;




    /*@Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_time")
    private Long updatedTime;*/

/*    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private List<Menu> menus;*/

}