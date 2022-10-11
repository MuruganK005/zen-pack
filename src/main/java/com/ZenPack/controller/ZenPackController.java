package com.ZenPack.controller;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.service.Impl.ZenPackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ZenPackController {

    @Autowired
    private ZenPackServiceImpl service;

    @PostMapping("/save")
    public ResponseEntity<ZenPack> saveZenPack(@RequestBody ZenPack zenPack) {
        return service.saveZenPack(zenPack);
    }

    @PostMapping("/create")
    public ResponseEntity<ZenPackDto> createZenPack(@RequestBody ZenPackDto createDto){
        return service.createZenPack(createDto);
    }
    @GetMapping("/get_all")
    public ResponseEntity<List<ZenPack>> getAllZenPack(){
        return service.getAllZenPack();
    }
  /*  @GetMapping("/sorting_enums")
    public ResponseEntity<ZenPackDto> sortingWithEnums(){
        return service.getBySortingWithEnums();
    }*/

}
