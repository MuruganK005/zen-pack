package com.ZenPack.service.Service;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.model.Feature;

import java.util.List;

public interface FeatureService {
    Feature createFeatureList(FeatureDto featureDto);

    List<Feature> getAllFeatureList();

    List<Feature> getFeatureBySearch(String keyword);

    Feature updateFeatureListById(FeatureDto dto);

    void deleteFeatureById(Long featureId);
}
