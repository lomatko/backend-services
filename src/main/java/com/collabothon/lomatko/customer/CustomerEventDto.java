package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.event.EventStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerEventDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventStatus status;
    private int coins;
    private String location;
    private int participants;
}
