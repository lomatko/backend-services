package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CustomerMapper.class)
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    Event mapToEvent(EventEntity eventEntity);
}
