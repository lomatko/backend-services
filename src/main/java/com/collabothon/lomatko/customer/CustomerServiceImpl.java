package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.reward.RewardEntity;
import com.collabothon.lomatko.reward.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

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
        Optional<CustomerEntity> customer = customerRepository.findById(customerId);
        Optional<RewardEntity> reward = rewardRepository.findFirstById(rewardId);
        int rewardPrice = reward.get().getPrice();
        int customerCoins = customer.get().getCoins();

        if (customerCoins >= rewardPrice) {
            customer.get().getRewards().add(reward.get());
            customerRepository.save(customer.get());
            return customerCoins - rewardPrice;
        }

        return customerCoins;
    }
}
