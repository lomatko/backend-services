package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Event {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int freeSpots;
    private EventStatus status;
}
