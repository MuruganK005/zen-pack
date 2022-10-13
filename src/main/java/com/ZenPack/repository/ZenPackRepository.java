package com.ZenPack.repository;

import com.ZenPack.model.ZenPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZenPackRepository extends JpaRepository<ZenPack,Integer> {

    void deleteByZenPackId(Long zenPackId);

    Optional<ZenPack> findByZenPackId(Long zenPackId);
}
