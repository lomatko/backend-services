package com.collabothon.lomatko.coin;

import jakarta.persistence.*;

@Entity
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer amount;

}
