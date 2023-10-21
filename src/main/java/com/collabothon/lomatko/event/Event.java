package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Event {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int spots;
    private EventStatus status;
    private int coins;
    private List<Volunteer> volunteers;
    private String location;
}
