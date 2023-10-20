package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.event.EventEntity;
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
}
