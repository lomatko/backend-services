package com.collabothon.lomatko.event;

import com.collabothon.lomatko.organization.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return EventMapper.INSTANCE.map(eventRepository.findAll());
    }

    @Override
    public void createEvent(OrganizationEntity organizationEntity, Event event) {
        EventEntity eventEntity = EventMapper.INSTANCE.mapToEventEntity(event).toBuilder()
                .organization(organizationEntity)
                .status(EventStatus.NEW)
                .build();
        eventRepository.saveAndFlush(eventEntity);
    }
}
