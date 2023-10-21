package com.collabothon.lomatko.customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String name;
    private int coins;
}
