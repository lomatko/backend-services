package com.collabothon.lomatko.organization;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface OrganizationDtoMapper {
    OrganizationDtoMapper INSTANCE = Mappers.getMapper(OrganizationDtoMapper.class);

    OrganizationDto mapToOrganizationDto(Organization organizationDto);

    List<OrganizationDto> map(List<Organization> organizations);
}
