package com.ZenPack.service;

import com.ZenPack.Dto.CreateDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ZenPackServiceImpl implements ZenPackService{


    @Autowired
    private ZenPackRepository repository;

    private static final Logger logger=LoggerFactory.getLogger(ZenPackServiceImpl.class);

    @Override
    public ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack) {
         repository.save(zenPack);
         logger.info("Zen-Pack Saved Successfully");
         return new ResponseEntity<>(zenPack, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CreateDto> createZenPack(CreateDto createDto) {
        ZenPack zenPack=new ZenPack();
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        ZenPack zenPack1=mapper.map(createDto,ZenPack.class);
        zenPack=repository.save(zenPack1);
        CreateDto dto=mapper.map(zenPack, CreateDto.class);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
}
