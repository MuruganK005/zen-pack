package com.ZenPack.service.Service;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import org.springframework.http.ResponseEntity;

public interface ZenPackService {
    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);

    ResponseEntity<ZenPackDto> createZenPack(ZenPackDto createDto);
}
