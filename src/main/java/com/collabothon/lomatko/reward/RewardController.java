package com.collabothon.lomatko.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rewards")
public class RewardController {

    private final RewardRepository rewardRepository;

    @Autowired
    public RewardController(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @GetMapping(produces = "application/json")
    public List<RewardEntity> getRewards() {
        return rewardRepository.findAll();
    }



}
