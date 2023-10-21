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
    public List<Reward> getRewards() {
        List<RewardEntity> rewards = service.getAll();
        return RewardMapper.INSTANCE.mapToRewards(rewards);
    }

    @GetMapping("/{id}")
    public List<Reward> getRewardsByUserId(@RequestParam Long id) {
        return RewardMapper.INSTANCE.mapToRewards(service.getAllById(id));
    }

    @PostMapping()
    public Reward addReward(@RequestBody RewardEntity reward) {
        return RewardMapper.INSTANCE.mapToReward(service.createNewReward(reward));
    }

    @DeleteMapping("/{id}")
    public void deleteReward(@PathVariable Long id) {
        service.deleteRewardById(id);
    }
}
