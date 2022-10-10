package com.ZenPack.service.Impl;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.model.Feature;
import com.ZenPack.repository.FeatureRepository;
import com.ZenPack.service.Service.FeatureService;
import io.swagger.models.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository repository;

    @Override
    public Feature createFeatureList(FeatureDto featureDto) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        Feature feature=mapper.map(featureDto,Feature.class);
        repository.save(feature);
        return feature;
    }

    @Override
    public List<Feature> getAllFeatureList() {
        return repository.findAll();
    }

    @Override
    public List<Feature> getFeatureBySearch(String keyword) {
        return repository.findByFeatureName(keyword);
    }

    @Override
    public Feature updateFeatureListById(FeatureDto dto) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
         Feature feature1=mapper.map(dto,Feature.class);
         repository.save(feature1);
        return feature1;
    }

    @Override
    public void deleteFeatureById(Long featureId) {
        repository.deleteByFeatureId(featureId);
    }
}
