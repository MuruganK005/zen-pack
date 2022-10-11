package com.ZenPack.service.Service;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZenPackService {
    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);

    ResponseEntity<ZenPackDto> createZenPack(ZenPackDto createDto);

    ResponseEntity<List<ZenPack>> getAllZenPack();
}
