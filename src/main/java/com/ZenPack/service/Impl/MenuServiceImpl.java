package com.ZenPack.service.Impl;

import com.ZenPack.Dto.MenuDto;
import com.ZenPack.repository.MenuRepository;
import com.ZenPack.service.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public ResponseEntity<MenuDto> addMenu(MenuDto dto) {
        return null;
    }
}
