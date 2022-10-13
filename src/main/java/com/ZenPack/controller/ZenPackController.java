package com.ZenPack.controller;

import com.ZenPack.Dto.ResponseDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.service.Impl.ZenPackServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<ZenPackDto> createZenPack(@RequestBody List<ZenPackDto> createDto) throws JsonProcessingException {
        return service.createZenPack(createDto);
    }
    @GetMapping(value = "get_all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZenPack>> getAllZenPack(){
        return service.getAllZenPack();
    }
    @DeleteMapping("/delete/{zenPackId}")
    public String deleteByZenPackId(@PathVariable Long zenPackId){
        return service.deleteByzenPackId(zenPackId);
    }
    @GetMapping("/getByZenPackId/{zenPackId}")
    public Optional<ZenPack> getByZenPackId(@PathVariable Long zenPackId){
        return service.getByZenPackId(zenPackId);
    }

}
