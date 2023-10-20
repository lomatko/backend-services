package com.collabothon.lomatko.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    @Autowired
    private RewardRepository repository;

    public List<RewardEntity> getAll() {
        return repository.findAll();
    }

    public List<RewardEntity> getAllById(Long id) {
        return repository.findAllById(id);
    }

    public RewardEntity createNewReward(RewardEntity entity) {
        repository.save(entity);
        return entity;
    }
}
