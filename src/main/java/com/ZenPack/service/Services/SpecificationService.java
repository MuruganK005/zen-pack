package com.ZenPack.service.Services;

import com.ZenPack.Dto.SpecificationDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.Specification.ZenPackSpecification;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpecificationService {
    @Autowired
    private ZenPackRepository repository;
//    public ResponseEntity<String> getBySpecification(boolean asc, SpecificationDto specificationDto) {
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setAmbiguityIgnored(true);
//        Sort.Direction sort = Sort.Direction.DESC;
//        if(asc){
//            sort = Sort.Direction.ASC;
//        }
//        ZenPackSpecification spec = new ZenPackSpecification(specificationDto);
//        Page<ZenPack> zenPacks=repository.findAll(spec, Pageable.unpaged());
////        Object mapperUtil = null;
//        List<ZenPackDto> zenPacks1=mapperUtil.toModelList(zenPacks.getContent(),ZenPackDto.class);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


    public ResponseEntity<Page<ZenPack>> getBySpecification(SpecificationDto specificationDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Sort.Direction sort = Sort.Direction.DESC;
//        if(asc){
//            sort = Sort.Direction.ASC;
//        }
        ZenPackSpecification spec = new ZenPackSpecification(specificationDto);
        Page<ZenPack> zenPacks=repository.findAll(spec, Pageable.unpaged());
//        Object mapperUtil = null;
//        List<ZenPackDto> zenPacks1=mapperUtil.toModelList(zenPacks.getContent(),ZenPackDto.class);
        return new ResponseEntity<>(zenPacks,HttpStatus.OK);
    }
}
