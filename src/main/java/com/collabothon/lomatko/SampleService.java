package com.collabothon.lomatko;

import com.collabothon.lomatko.customer.Customer;
import com.collabothon.lomatko.customer.CustomerEntity;
import com.collabothon.lomatko.customer.CustomerMapper;
import com.collabothon.lomatko.customer.CustomerRepository;
import com.collabothon.lomatko.reward.RewardEntity;
import com.collabothon.lomatko.reward.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final CustomerRepository customerRepository;
    private final RewardRepository rewardRepository;

    @EventListener
    public void handleContextStart(ContextStartedEvent cse) {
        System.out.println("Handling context started event.");
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(1L)
                .name("sample")
                .build();

        customerRepository.save(customerEntity);
        customerRepository.flush();

        CustomerEntity entityLoaded = customerRepository.findById(1L).orElseThrow(() -> new RuntimeException("nie ma takiego entity"));
        Customer customer = CustomerMapper.INSTANCE.mapToCustomer(entityLoaded);
        System.out.printf("Loaded customer: " + customer);

        RewardEntity rewardEntity = RewardEntity.builder()
                .id(1L)
                .name("brak prowizji na rok")
                .description("opis nagrody")
                .price(110)
                .build();

        rewardRepository.save(rewardEntity);
        rewardRepository.flush();
    }
}
