package com.ZenPack.controller;

import com.ZenPack.Dto.MenuDto;
import com.ZenPack.service.Impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MenuController {

    @Autowired
    private MenuServiceImpl service;

//    @PostMapping("/add_menu")
//    public ResponseEntity<MenuDto> addMenu(@RequestBody MenuDto dto){
//        MenuDto dto1=service.addMenu(dto)
//       return new ResponseEntity<>(, HttpStatus.CREATED);
//    }
}
