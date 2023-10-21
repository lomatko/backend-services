package com.collabothon.lomatko.organization;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImp implements OrganizationService{

    private final OrganizationRepository repository;

    @Override
    public List<Organization> getAll() {
        return OrganizationMapper.INSTANCE.map(repository.findAll());
    }

    @Override
    public Organization findById(Long id) {
        return OrganizationMapper.INSTANCE.mapToOrganization(repository.findById(id).orElse(null));
    }

    @Override
    public void addOrganization(OrganizationDto organizationDto) {
        OrganizationEntity entity = OrganizationEntity.builder()
                .name(organizationDto.getName())
                .description(organizationDto.getDescription())
                .build();
        repository.save(entity);
    }
}
