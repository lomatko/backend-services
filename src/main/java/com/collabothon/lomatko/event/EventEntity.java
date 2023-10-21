package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int spots;

    private int coins;

    private String location;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @ManyToMany(mappedBy = "events")
    private List<CustomerEntity> volunteers;
}
