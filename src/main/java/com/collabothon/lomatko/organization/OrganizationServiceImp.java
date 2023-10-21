package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.customer.CustomerEntity;
import com.collabothon.lomatko.customer.CustomerRepository;
import com.collabothon.lomatko.event.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImp implements OrganizationService {

    private final OrganizationRepository repository;
    private final EventService eventService;
    private final EventRepository eventRepository;
    private final CustomerRepository customerRepository;

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

    @Override
    public void deleteOrganization(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void addEvent(Long organizationId, Event event) {
        OrganizationEntity organizationEntity = repository.findById(organizationId).orElseThrow(() -> new RuntimeException("Can't add event to non existing organization with id: " + organizationId));
        eventService.createEvent(organizationEntity, event);
    }

    @Transactional
    @Override
    public void confirmEvent(Long organizationId, Long eventId, List<VolunteerDto> participation) {
        EventEntity event = eventRepository.findById(eventId).orElse(null);
        if (event == null) {
            throw new RuntimeException("Event entity cannot be null");
        }

        confirmedParticipantsAndCompleteTheEvent(participation, event);
        addCoinToParticipants(participation, event.getCoins());
    }

    @Override
    public List<Event> getEvents(Long id) {
        OrganizationEntity entity = repository.findById(id).orElse(null);
        if(entity != null) {
            return EventMapper.INSTANCE.map(entity.getEvents());
        }
        return null;
    }

    @Override
    public Long getTotalVolunteerTimeByBank() {
        long total = 0;
        List<OrganizationEntity> entities = repository.findAll();
        for(OrganizationEntity entity : entities) {
            total += getTimeByOrganization(entity);
        }
        return total;
    }

    @Override
    public Long getTotalVolunteerTimeByOrganization(Long id) {
        long total = 0;
        OrganizationEntity entity = repository.findById(id).orElse(null);
        if(entity != null) {
            total += getTimeByOrganization(entity);
        }
        return total;
    }

    private Long getTimeByOrganization(OrganizationEntity entity) {
        long total = 0;
        for(EventEntity event : entity.getEvents()) {
            if(event.getStatus() == EventStatus.COMPLETED){
                total += (long) event.getVolunteers().size() * event.getCoins();
            }
        }
        return total;
    }

    private void addCoinToParticipants(List<VolunteerDto> participation, int amount) {
        for (VolunteerDto volunteer : participation) {
            customerRepository.findById(volunteer.getId()).ifPresent(entityBeforeUpdate -> customerRepository.saveAndFlush(CustomerEntity.builder()
                    .id(entityBeforeUpdate.getId())
                    .name(entityBeforeUpdate.getName())
                    .coins(entityBeforeUpdate.getCoins() + amount)
                    .rewards(entityBeforeUpdate.getRewards())
                    .events(entityBeforeUpdate.getEvents())
                    .build()));
        }
    }

    private void confirmedParticipantsAndCompleteTheEvent(List<VolunteerDto> participants, EventEntity event) {
        List<CustomerEntity> volunteers = new ArrayList<>();

        for (VolunteerDto volunteerDto : participants) {
            volunteers.add(customerRepository.findById(volunteerDto.getId()).orElse(null));
        }

        eventRepository.saveAndFlush(EventEntity.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .spots(event.getSpots())
                .coins(event.getCoins())
                .location(event.getLocation())
                .status(EventStatus.COMPLETED)
                .volunteers(volunteers)
                .organization(event.getOrganization())
                .build());
    }
}
