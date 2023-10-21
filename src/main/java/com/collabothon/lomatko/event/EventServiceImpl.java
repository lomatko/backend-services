package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerEntity;
import com.collabothon.lomatko.customer.CustomerRepository;
import com.collabothon.lomatko.organization.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final CustomerRepository customerRepository;

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

    @Override
    public void joinEvent(Long customerId, Long eventId) {
        Objects.requireNonNull(customerId, "Can't join event because customerId is null!");
        Objects.requireNonNull(eventId, "Can't join event because eventId is null!");

        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer with id: " + customerId + " doesn't exist"));
        EventEntity event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event with id: " + eventId + " doesn't exist"));

        List<CustomerEntity> volunteers = event.getVolunteers();
        if (volunteers == null) {
            System.out.println("=========mamy null!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            volunteers = new ArrayList<>();
        }
        volunteers.add(customer);
        event = eventRepository.saveAndFlush(event.toBuilder().volunteers(volunteers).build());

        List<EventEntity> events = customer.getEvents();
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
        customerRepository.saveAndFlush(customer.toBuilder().events(events).build());
    }
}
