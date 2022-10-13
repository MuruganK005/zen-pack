package com.ZenPack.service.Impl;

import com.ZenPack.Dto.MenuDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Service.ZenPackService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Slf4j
@Transactional
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
    public ResponseEntity<ZenPackDto> createZenPack(List<ZenPackDto> createDto) throws JsonProcessingException {
        ZenPackDto zenPackDto1 = null;
        for (ZenPackDto zenPackDto : createDto) {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setAmbiguityIgnored(true);
            ZenPack zenPack = mapper.map(zenPackDto, ZenPack.class);
/*            ObjectMapper objectMapper=new ObjectMapper();
            String menuJson=objectMapper.writeValueAsString(zenPackDto.getMenus());*/
            String menuJson = new Gson().toJson(zenPackDto.getMenus());
            Gson gson = new Gson();
            MenuDto[] userArray = gson.fromJson(menuJson, MenuDto[].class);
            zenPack.setJsonData(menuJson);
            zenPackDto1 = new ZenPackDto();
            zenPackDto1.setZenPackId(zenPack.getZenPackId());
            zenPackDto1.setName(zenPack.getName());
            zenPackDto1.setMenus(Arrays.stream(userArray).toList());
            repository.save(zenPack);
            return new ResponseEntity<>(zenPackDto1, HttpStatus.ACCEPTED);
        }
        /* *//*ZenPack zenPack=new ZenPack();
    ObjectMapper mapper=new ObjectMapper();
    String gson= new Gson().toJson(createDto);
    zenPack.setJsonData(mapper.writeValueAsString(createDto));
    repository.save(zenPack);*//*
    ResponseDto responseDto=new ResponseDto();
    responseDto.setResponseMessage("ZenPack Created Successfully");
    responseDto.setResponseCode("Ok");
    responseDto.setStatusCode(200);
    responseDto.setResponseDescription("ZenPack Created Successfully");
    responseDto.setData(null);
    Gson gson1=new Gson();
    ZenPackDto zenPackDto=gson1.fromJson(gson,ZenPackDto.class);
    responseDto.setJdata(zenPackDto);

    return responseDto;*/
        return new ResponseEntity<>(zenPackDto1, HttpStatus.ACCEPTED);
    }
    @Override
    public ResponseEntity<List<ZenPack>> getAllZenPack() {
/*        List<ZenPackDto> dtos = new ArrayList<>();*/
        List<ZenPack> zenPacks = repository.findAll();
/*        List<ZenPackDto> zenPackDto2 = null;*/
      /*  for (ZenPack zenPackDto : zenPacks) {
            Gson gson = new Gson();
            MenuDto[] userArray = gson.fromJson(zenPackDto.getJsonData(), MenuDto[].class);
            ZenPackDto zenPackDto1 = new ZenPackDto();
            zenPackDto1.setMenus(Arrays.stream(userArray).toList());
            zenPackDto1.setName(zenPackDto.getName());
            dtos.add(zenPackDto1);*/
/*            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setAmbiguityIgnored(true);
            zenPackDto2 = Collections.singletonList(mapper.map(zenPacks, ZenPackDto.class));*/
        /*    return new ResponseEntity<>(zenPackDto2, HttpStatus.ACCEPTED);*/
    /*    }*/
        return new ResponseEntity<>(zenPacks, HttpStatus.ACCEPTED);
    }

    @Override
    public String deleteByzenPackId(Long zenPackId) {
        repository.deleteByZenPackId(zenPackId);
        return  " Id "+zenPackId+" Deleted SuccessFully";
    }

    @Override
    public Optional<ZenPack> getByZenPackId(Long zenPackId) {
       Optional<ZenPack> zenPack= repository.findByZenPackId(zenPackId);
   /*    ModelMapper mapper=new ModelMapper();
       mapper.getConfiguration().setAmbiguityIgnored(true);
       ZenPackDto dto=mapper.map(zenPack,ZenPackDto.class);*/
        return zenPack;
    }
}
