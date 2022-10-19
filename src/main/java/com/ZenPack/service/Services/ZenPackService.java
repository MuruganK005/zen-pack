package com.ZenPack.service.Services;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface  ZenPackService {
    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);

    ResponseEntity<ZenPackDto> createZenPack(ZenPackDto createDto) throws JsonProcessingException;

    List<ZenPackDto> getAllZenPack() throws JsonProcessingException;

    String deleteByzenPackId(Long zenPackId);

    ZenPackDto getByZenPackId(Long zenPackId);
    
    boolean checkZenPackName(String name);
}
