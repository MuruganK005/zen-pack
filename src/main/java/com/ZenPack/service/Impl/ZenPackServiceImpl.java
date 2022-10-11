package com.ZenPack.service.Impl;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Service.ZenPackService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Slf4j
public class ZenPackServiceImpl implements ZenPackService {


    @Autowired
    private ZenPackRepository repository;

    @Autowired
    private EntityManager manager;

    private static final Logger logger=LoggerFactory.getLogger(ZenPackServiceImpl.class);

    @Override
    public ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack) {
         repository.save(zenPack);
         logger.info("Zen-Pack Saved Successfully");
         return new ResponseEntity<>(zenPack, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ZenPackDto> createZenPack(ZenPackDto createDto) {
        try {
            ZenPack zenPack;
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setAmbiguityIgnored(true);
            ZenPack zenPack1 = mapper.map(createDto, ZenPack.class);
            zenPack = repository.save(zenPack1);
            //List<ZenPack> zenPacks=manager.createNativeQuery("select * from zenpack where JSON_SEARCH(items, 'all', 'Menu menuName') IS NOT NULL", Store.class).getResultList();
            //log.info(zenPacks.toString());
            //zenPacks=repository.findAll();
            ZenPackDto dto = mapper.map(zenPack, ZenPackDto.class);
            return new ResponseEntity<>(dto,HttpStatus.CREATED);
        }
        catch (Exception e){
            throw e;
        }

    }
    @Override
    public ResponseEntity<List<ZenPack>> getAllZenPack() {
       List<ZenPack> zenPacks= repository.findAll();
        return new ResponseEntity<>(zenPacks,HttpStatus.ACCEPTED);
    }
}
