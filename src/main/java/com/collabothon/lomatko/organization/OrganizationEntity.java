package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.event.EventEntity;
import com.collabothon.lomatko.reward.RewardEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "organization")
@Getter
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @OneToMany
    @JoinTable(
            name = "organization_events",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<EventEntity> events;
}
