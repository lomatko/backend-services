package com.collabothon.lomatko.customer;

import com.collabothon.lomatko.event.Event;
import com.collabothon.lomatko.event.EventEntity;
import com.collabothon.lomatko.event.VolunteerMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = VolunteerMapper.class)
public interface CustomerEventMapper {
    CustomerEventMapper INSTANCE = Mappers.getMapper(CustomerEventMapper.class);

    CustomerEvent mapToCustomerEvent(EventEntity eventEntity);

    List<CustomerEvent> mapToCustomerEvents(List<EventEntity> eventEntities);
}
