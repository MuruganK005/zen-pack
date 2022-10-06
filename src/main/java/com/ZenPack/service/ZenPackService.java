package com.ZenPack.service;

import com.ZenPack.model.ZenPack;
import org.springframework.http.ResponseEntity;

public interface ZenPackService {
    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);
}
