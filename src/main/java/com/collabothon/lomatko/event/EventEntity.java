package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerEntity;
import com.collabothon.lomatko.organization.OrganizationEntity;
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
@Builder(toBuilder = true)
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

    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private List<CustomerEntity> volunteers;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;
}
