package com.collabothon.lomatko.reward;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "rewards")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Price is required")
    private Integer price;
}
