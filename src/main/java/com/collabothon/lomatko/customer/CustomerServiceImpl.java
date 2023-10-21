package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.reward.RewardEntity;
import com.collabothon.lomatko.reward.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RewardRepository rewardRepository;
    @Override
    public Customer findCustomerById(Long id) {
        Objects.requireNonNull(id, "Can't find customer because passed id is null");
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer with given ID: " + id + " doesn't exist"));
        return CustomerMapper.INSTANCE.mapToCustomer(customerEntity);
    }

    @Override
    public Integer addRewardToCustomer(Long customerId, Long rewardId) {
        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("no customer with id"));
        RewardEntity reward = rewardRepository.findById(rewardId).orElseThrow(() -> new RuntimeException("no reward with id"));
        int rewardPrice = reward.getPrice();
        int customerCoins = customer.getCoins();

        if (customerCoins < rewardPrice) {
            throw new IllegalArgumentException();
        } else {
            customer.getRewards().add(reward);
            customer.setCoins(customerCoins - rewardPrice);
            customerRepository.save(customer);
            customerRepository.flush();
            return customerCoins - rewardPrice;
        }
    }
}
