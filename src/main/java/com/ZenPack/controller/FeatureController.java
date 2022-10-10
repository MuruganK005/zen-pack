package com.ZenPack.controller;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.model.Feature;
import com.ZenPack.service.Impl.FeatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeatureController {

    @Autowired
    private FeatureServiceImpl service;

    @PostMapping("/create_feature_list")
    @ResponseStatus(HttpStatus.CREATED)
    public Feature create(@RequestBody FeatureDto featureDto){
        return service.createFeatureList(featureDto);
    }

    @GetMapping("/get_feature_list")
    @ResponseStatus(HttpStatus.OK)
    public List<Feature> findAllFeatureList(){
        return service.getAllFeatureList();
    }

    @GetMapping("/search_by_name")
    @ResponseStatus(HttpStatus.OK)
    public List<Feature> findByFeatureNameInList(@RequestParam String keyword){
        return service.getFeatureBySearch(keyword);
    }

    @PutMapping("/update_list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Feature updateList(@RequestBody FeatureDto dto){
        return service.updateFeatureListById(dto);
    }

    @DeleteMapping("/deleteList/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeatureNameById(@PathVariable Long featureId){
        service.deleteFeatureById(featureId);
    }

}
