package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.event.EventDto;
import com.collabothon.lomatko.event.EventDtoMapper;
import com.collabothon.lomatko.event.EventService;
import lombok.RequiredArgsConstructor;
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

}
