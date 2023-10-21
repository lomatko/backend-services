package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.event.EventStatus;
import com.collabothon.lomatko.event.Volunteer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CustomerEvent {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int spots;
    private EventStatus status;
    private int coins;
    private String location;
}
