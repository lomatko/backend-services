package com.collabothon.lomatko.reward;

import com.collabothon.lomatko.customer.CustomerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "reward")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class RewardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    private Integer price;

    @ManyToMany(mappedBy = "rewards")
    private List<CustomerEntity> volunteers;
}
