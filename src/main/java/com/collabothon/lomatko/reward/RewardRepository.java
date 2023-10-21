package com.collabothon.lomatko.reward;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RewardRepository extends JpaRepository<RewardEntity, Long> {

    List<RewardEntity> findAll();

    List<RewardEntity> findAllById(Long id);

    Optional<RewardEntity> findFirstById(Long id);
}
