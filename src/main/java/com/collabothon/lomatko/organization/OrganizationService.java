package com.collabothon.lomatko.organization;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private OrganizationRepository repository;

    public List<OrganizationEntity> getAll() {
        return repository.findAll();
    }

    public void addOrganization(OrganizationDto organizationDto) {
        repository.save(organizationDto);
    }

    public OrganizationEntity findById(long id) {
        return repository.findById(id).orElse(null);
    }

}
