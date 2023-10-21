package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.reward.RewardMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CustomerEventMapper.class, RewardMapper.class})
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer mapToCustomer(CustomerEntity customerEntity);
}
