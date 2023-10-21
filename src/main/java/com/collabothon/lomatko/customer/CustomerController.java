package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.reward.RewardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/{customerId}", produces = "application/json")
    public CustomerDto getCustomer(@PathVariable Long customerId) {
        return CustomerDtoMapper.INSTANCE.mapToCustomerDto(customerService.findCustomerById(customerId));
    }

    @GetMapping(value = "/{customerId}/events", produces = "application/json")
    public List<CustomerEventDto> getCustomerEvents(@PathVariable Long customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        return CustomerEventDtoMapper.INSTANCE.mapTocCustomerEventDtos(customer.getEvents());
    }

    @GetMapping(value = "/{customerId}/rewards", produces = "application/json")
    public List<RewardEntity> getCustomerRewards(@PathVariable Long customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        return customer.getRewards();
    }

    @PostMapping(value = "/{customerId}/rewards/{rewardId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity<String> addRewardToCustomer(@PathVariable Long customerId, @PathVariable Long rewardId) {
        try {
            String x = String.valueOf(customerService.addRewardToCustomer(customerId, rewardId));
            return new ResponseEntity<>(x, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.LOCKED);
        }
    }
}
