package com.collabothon.lomatko.organization;

import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    private OrganizationRepository repository;

    public OrganizationEntity addOrganization (OrganizationEntity organizationEntity) {
        return repository.save(organizationEntity);
    }


}
