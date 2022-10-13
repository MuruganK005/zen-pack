package com.ZenPack.service.Service;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface ZenPackService {
    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);

    ResponseEntity<ZenPackDto> createZenPack(List<ZenPackDto> createDto) throws JsonProcessingException;

    List<ZenPack> getAllZenPack() throws JsonProcessingException;

    String deleteByzenPackId(Long zenPackId);

    Optional<ZenPack> getByZenPackId(Long zenPackId);
}