package com.ZenPack.repository;

import com.ZenPack.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<Feature,Integer> {

    @Query("SELECT p FROM Feature p WHERE p.featureName LIKE %:keyword%" )
    List<Feature> findByFeatureName(String keyword);

    void deleteByFeatureId(Long featureId);
}
