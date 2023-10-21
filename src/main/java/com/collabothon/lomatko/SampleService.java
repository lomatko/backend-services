package com.collabothon.lomatko;

import com.collabothon.lomatko.customer.Customer;
import com.collabothon.lomatko.customer.CustomerEntity;
import com.collabothon.lomatko.customer.CustomerMapper;
import com.collabothon.lomatko.customer.CustomerRepository;
import com.collabothon.lomatko.event.EventEntity;
import com.collabothon.lomatko.event.EventRepository;
import com.collabothon.lomatko.event.EventStatus;
import com.collabothon.lomatko.reward.RewardEntity;
import com.collabothon.lomatko.reward.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final CustomerRepository customerRepository;
    private final EventRepository eventRepository;
    private final RewardRepository rewardRepository;

    @EventListener
    public void handleContextStart(ContextStartedEvent cse) {
        System.out.println("Handling context started event.");
        loadCustomer();
        loadEvent();
        loadReward();

        CustomerEntity entityLoaded = customerRepository.findById(1L).orElseThrow(() -> new RuntimeException("nie ma takiego entity"));
        Customer customer = CustomerMapper.INSTANCE.mapToCustomer(entityLoaded);
        System.out.printf("Loaded customer: " + customer);
    }

    private void loadEvent() {
        CustomerEntity customer = customerRepository.findById(1L).orElseThrow(() -> new RuntimeException("nie ma takiego entity"));
        EventEntity event = EventEntity.builder()
                .volunteers(Collections.singletonList(customer))
                .title("event title")
                .description("event description")
                .spots(20)
                .coins(2)
                .endDate(LocalDateTime.now())
                .startDate(LocalDateTime.now())
                .status(EventStatus.NEW)
                .id(11L)
                .build();
        eventRepository.saveAndFlush(event);
    }

    private void loadCustomer() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(1L)
                .name("sample")
                .build();

        customerRepository.save(customerEntity);
        customerRepository.flush();
    }

    private void loadReward() {
        RewardEntity rewardEntity1 = RewardEntity.builder()
                .id(1L)
                .name("reward #1")
                .description("opis 1")
                .price(22)
                .build();

        RewardEntity rewardEntity2 = RewardEntity.builder()
                .id(2L)
                .name("reward #2")
                .description("opis 2")
                .price(5)
                .build();

        RewardEntity rewardEntity3 = RewardEntity.builder()
                .id(3L)
                .name("reward #3")
                .description("opis 3")
                .price(30)
                .build();

        rewardRepository.save(rewardEntity1);
        rewardRepository.save(rewardEntity2);
        rewardRepository.save(rewardEntity3);
        customerRepository.flush();
    }
}
