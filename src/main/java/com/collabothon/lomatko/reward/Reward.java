package com.collabothon.lomatko.reward;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Reward {
    private Long id;
    private String name;
    private String description;
    private int price;
}
