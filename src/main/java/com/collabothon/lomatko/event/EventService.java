package com.collabothon.lomatko.event;

import com.collabothon.lomatko.organization.OrganizationEntity;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    void createEvent(OrganizationEntity organizationEntity, Event event);

    void joinEvent(Long customerId, Long eventId);

    void leaveEvent(Long customerId, Long eventId);
}
