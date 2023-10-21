package com.collabothon.lomatko.customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Customer {
    private Long id;
    private String name;
    private int coins;
}
