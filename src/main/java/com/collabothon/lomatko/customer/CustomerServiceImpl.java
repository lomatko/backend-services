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
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customerId);
        Optional<RewardEntity> reward = rewardRepository.findFirstById(rewardId);
        CustomerEntity customer = customerEntity.get();
        int rewardPrice = reward.get().getPrice();
        int customerCoins = customer.getCoins();

        if (customerCoins < rewardPrice) {
            throw new IllegalArgumentException();
        } else {
            customer.getRewards().add(reward.get());
            customerRepository.save(customer);
            return customerCoins - rewardPrice;
        }
    }
}
