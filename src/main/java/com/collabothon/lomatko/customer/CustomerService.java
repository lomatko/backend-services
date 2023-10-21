package com.collabothon.lomatko.customer;

public interface CustomerService {
    Customer findCustomerById(Long id);

    Integer addRewardToCustomer(Long customerId, Long rewardId) throws IllegalArgumentException;
}
