package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.event.EventEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "organization")
@Getter
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "organization")
    private List<EventEntity> events;
}
