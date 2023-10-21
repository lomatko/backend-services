package com.collabothon.lomatko.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer findCustomerById(Long id) {
        Objects.requireNonNull(id, "Can't find customer because passed id is null");
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer with given ID: " + id + " doesn't exist"));
        return CustomerMapper.INSTANCE.mapToCustomer(customerEntity);
    }
}
