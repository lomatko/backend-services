package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.event.EventEntity;
import com.collabothon.lomatko.reward.RewardEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private int coins;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "customer_events",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<EventEntity> events;

    @ManyToMany
    @JoinTable(
            name = "customer_rewards",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "reward_id"))
    private List<RewardEntity> rewards;
}
