package com.collabothon.lomatko.customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerEventDtoMapper {
    CustomerEventDtoMapper INSTANCE = Mappers.getMapper(CustomerEventDtoMapper.class);
    @Mapping(target = "participants", source = "spots")
    CustomerEventDto mapToCustomerEventDto(CustomerEvent event);
    List<CustomerEventDto> mapTocCustomerEventDtos(List<CustomerEvent> events);
}
