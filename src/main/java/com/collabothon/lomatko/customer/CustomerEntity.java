package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.event.EventEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "customer_events",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<EventEntity> events;
}
