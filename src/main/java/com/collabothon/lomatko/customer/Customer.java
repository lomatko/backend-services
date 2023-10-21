package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.reward.RewardEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class Customer {
    private Long id;
    private String name;
    private int coins;
    private List<CustomerEvent> events;
    private List<RewardEntity> rewards;
}
