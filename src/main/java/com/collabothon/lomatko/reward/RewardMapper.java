package com.collabothon.lomatko.reward;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RewardMapper {
    RewardMapper INSTANCE = Mappers.getMapper(RewardMapper.class);

    Reward mapToReward(RewardEntity rewardEntity);

    List<Reward> mapToRewards(List<RewardEntity> rewardEntities);
}
