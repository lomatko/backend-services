package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.reward.RewardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
