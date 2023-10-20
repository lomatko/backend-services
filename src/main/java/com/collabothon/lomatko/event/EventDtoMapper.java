package com.collabothon.lomatko.event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = VolunteerDtoMapper.class)
public interface EventDtoMapper {
    EventDtoMapper INSTANCE = Mappers.getMapper(EventDtoMapper.class);
    @Mapping(target = "participants", source = "spots")
    EventDto mapToEventDto(Event event);

    List<EventDto> mapToEventDtos(List<Event> events);
}
