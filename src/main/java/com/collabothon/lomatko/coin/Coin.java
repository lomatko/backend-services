package com.collabothon.lomatko.coin;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

public class Coin {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer amount;
}
