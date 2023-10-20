package com.collabothon.lomatko.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rewards")
public class RewardController {

    @Autowired
    private RewardService service;

    @GetMapping()
    public List<RewardEntity> getRewards() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public List<RewardEntity> getRewardsByUserId(@RequestParam Long id) {
        return service.getAllById(id);
    }

    @PostMapping()
    public RewardEntity addReward(@RequestBody RewardEntity reward) {
        return service.createNewReward(reward);


    }



}
