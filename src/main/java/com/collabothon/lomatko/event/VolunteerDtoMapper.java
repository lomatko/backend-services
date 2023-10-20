package com.collabothon.lomatko.event;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VolunteerDtoMapper {
    VolunteerDtoMapper INSTANCE = Mappers.getMapper(VolunteerDtoMapper.class);

    VolunteerDto mapToVolunteerDto(Volunteer volunteer);

    List<VolunteerDto> mapToVolunteerDtos(List<Volunteer> volunteers);

}
