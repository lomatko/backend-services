package com.collabothon.lomatko.customer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer mapToCustomer(CustomerEntity customerEntity);
}
