package com.ZenPack.service.Impl;

import com.ZenPack.Dto.MenuDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.Menu;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.*;

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
    public ZenPackDto createZenPack(ZenPackDto createDto) throws JsonProcessingException {
        ZenPackDto zenPackDto1 = null;
       // for (ZenPackDto zenPackDto : createDto) {
     // convert request object into json objec
	  JSONObject zenpackJson = new JSONObject(createDto);
	  zenPackDto1 = new Gson().fromJson(zenpackJson.toString(), ZenPackDto.class);
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setAmbiguityIgnored(true);
            ZenPack zenPack = mapper.map(zenPackDto1, ZenPack.class);
/*            ObjectMapper objectMapper=new ObjectMapper();
            String menuJson=objectMapper.writeValueAsString(zenPackDto.getMenus());*/
            JSONArray menuJson = zenpackJson.getJSONArray("menus");
            MenuDto[] userArray = new Gson().fromJson(menuJson.toString(), MenuDto[].class);
           // String menuJson = new Gson().toJson(zenPackDto.getMenus());
            Gson gson = new Gson();
           // MenuDto[] userArray = gson.fromJson(menuJson, MenuDto[].class);
            zenPack.setJsonData(menuJson.toString());
            zenPackDto1 = new ZenPackDto();
            zenPackDto1.setZenPackId(zenPack.getZenPackId());
            zenPackDto1.setName(zenPack.getName());
            zenPackDto1.setMenus(Arrays.asList(userArray));
            repository.save(zenPack);
//        }
        return zenPackDto1;
    }


/*         ZenPack zenPack=new ZenPack();
    ObjectMapper mapper=new ObjectMapper();
    String gson= new Gson().toJson(createDto);
    zenPack.setJsonData(mapper.writeValueAsString(createDto));
    repository.save(zenPack);*/
   /* ResponseDto responseDto=new ResponseDto();
    responseDto.setResponseMessage("ZenPack Created Successfully");
    responseDto.setResponseCode("Ok");
    responseDto.setStatusCode(200);
    responseDto.setResponseDescription("ZenPack Created Successfully");
    responseDto.setData(null);
    Gson gson1=new Gson();
    ZenPackDto zenPackDto=gson1.fromJson(gson,ZenPackDto.class);
    responseDto.setJdata(zenPackDto);*/
  /*  return responseDto;
        return new ResponseEntity<>(zenPackDto1, HttpStatus.ACCEPTED);
    }*/
    @Override
    public List<ZenPack> getAllZenPack() throws JsonProcessingException {
        List<ZenPack> zenPacks = repository.findAll();
        return zenPacks;
    }

    @Override
    public String deleteByzenPackId(Long zenPackId) {
        repository.deleteByZenPackId(zenPackId);
        return  " Id "+zenPackId+" Deleted SuccessFully";
    }

    @Override
    public Optional<ZenPack> getByZenPackId(Long zenPackId) {
        Optional<ZenPack> zenPack= repository.findByZenPackId(zenPackId);
        return zenPack;
    }
}