package com.collabothon.lomatko.reward;

import com.collabothon.lomatko.customer.CustomerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "reward")
@Getter
public class RewardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Price is required")
    private Integer price;

    @ManyToMany(mappedBy = "rewards")
    private List<CustomerEntity> volunteers;
}
