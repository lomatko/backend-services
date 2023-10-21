package com.collabothon.lomatko.organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getAll();
    Organization findById(Long id);
    void addOrganization(OrganizationDto organizationDto);
}
