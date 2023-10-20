package com.collabothon.lomatko.reward;

import com.collabothon.lomatko.coin.Coin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Table(name = "rewards")
public class Reward {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Coin coin;
}
