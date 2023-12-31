package com.collabothon.lomatko;

import com.collabothon.lomatko.customer.CustomerEntity;
import com.collabothon.lomatko.customer.CustomerRepository;
import com.collabothon.lomatko.event.EventEntity;
import com.collabothon.lomatko.event.EventRepository;
import com.collabothon.lomatko.event.EventStatus;
import com.collabothon.lomatko.organization.OrganizationEntity;
import com.collabothon.lomatko.organization.OrganizationRepository;
import com.collabothon.lomatko.reward.RewardEntity;
import com.collabothon.lomatko.reward.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final CustomerRepository customerRepository;
    private final EventRepository eventRepository;
    private final OrganizationRepository organizationRepository;
    private final RewardRepository rewardRepository;

//    @EventListener
    public void handleContextStart(ContextStartedEvent cse) {
        System.out.println("Handling context started event.");
        loadCustomer();
        loadOrganization();
        loadRewards();

        System.out.println("Sample data inserted to DB.");
    }

    private EventEntity loadEvent(OrganizationEntity organizationEntity, EventStatus eventStatus) {
        CustomerEntity customer = customerRepository.findById(1L).orElseThrow(() -> new RuntimeException("there is no Customer entity"));
        EventEntity event = EventEntity.builder()
                .volunteers(Collections.singletonList(customer))
                .organization(organizationEntity)
                .title("event title")
                .description("event description")
                .location("Łódź, Mazurska 12")
                .spots(20)
                .coins(2)
                .endDate(LocalDateTime.now())
                .startDate(LocalDateTime.now())
                .status(eventStatus)
                .build();
        event = eventRepository.saveAndFlush(event);

        List<EventEntity> events = customer.getEvents();
        if (events == null) {
            events = new ArrayList<>();
        } else {
            events = new ArrayList<>(events);
        }
        events.add(event);

        customerRepository.saveAndFlush(customer.toBuilder().events(events).build());
        return event;
    }

    private void loadCustomer() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(1L)
                .name("sample")
                .coins(100)
                .events(new ArrayList<>())
                .build();

        customerRepository.save(customerEntity);
        customerRepository.flush();
    }

    private void loadOrganization() {
        OrganizationEntity organizationEntity = OrganizationEntity.builder()
                .name("charity_name")
                .description("description_for_charity")
                .build();
        organizationEntity = organizationRepository.saveAndFlush(organizationEntity);
        loadEvent(organizationEntity, EventStatus.NEW);
        loadEvent(organizationEntity, EventStatus.COMPLETED);
    }

    private void loadRewards() {
        RewardEntity rewardEntity1 = RewardEntity.builder()
                .name("reward 1")
                .description("opis 1")
                .price(11)
                .build();

        RewardEntity rewardEntity2 = RewardEntity.builder()
                .name("reward 2")
                .description("opis 2")
                .price(100)
                .build();

        RewardEntity rewardEntity3 = RewardEntity.builder()
                .name("reward 3")
                .description("opis 3")
                .price(111)
                .build();

        rewardRepository.save(rewardEntity1);
        rewardRepository.save(rewardEntity2);
        rewardRepository.save(rewardEntity3);
        rewardRepository.flush();
    }
}
