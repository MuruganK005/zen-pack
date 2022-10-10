package com.ZenPack.service.Service;

import com.ZenPack.Dto.MenuDto;
import org.springframework.http.ResponseEntity;

public interface MenuService {
    ResponseEntity<MenuDto> addMenu(MenuDto dto);
}
