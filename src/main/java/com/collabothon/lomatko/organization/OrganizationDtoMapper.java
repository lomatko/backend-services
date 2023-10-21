package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.event.EventDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper(uses = EventDtoMapper.class)
@Mapper
public interface OrganizationDtoMapper {
    OrganizationDtoMapper INSTANCE = Mappers.getMapper(OrganizationDtoMapper.class);

    OrganizationDto mapToOrganizationDto(OrganizationDto organizationDto);

    List<OrganizationDto> map (List<Organization> organizations);
}
