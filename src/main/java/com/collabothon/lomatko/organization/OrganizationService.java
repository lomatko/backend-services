package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.event.Event;

import java.util.List;

public interface OrganizationService {
    List<Organization> getAll();
    Organization findById(Long id);
    void addOrganization(OrganizationDto organizationDto);
    void deleteOrganization(Long id);

    void addEvent(Long organizationId, Event event);
}
