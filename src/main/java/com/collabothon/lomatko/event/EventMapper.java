package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    Event mapToEvent(EventEntity eventEntity);

    List<Event> map(List<EventEntity> eventEntities);
}
