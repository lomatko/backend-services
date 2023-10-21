package com.collabothon.lomatko.organization;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrganizationMapper {
    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    Organization mapToOrganization(OrganizationEntity organizationEntity);

    List<Organization> map(List<OrganizationEntity> organizationEntities);
}
