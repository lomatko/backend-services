package com.collabothon.lomatko.customer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CustomerEventMapper.class)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer mapToCustomer(CustomerEntity customerEntity);
}
