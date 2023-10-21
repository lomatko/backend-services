package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.event.Event;
import com.collabothon.lomatko.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImp implements OrganizationService{

    private final OrganizationRepository repository;
    private final EventService eventService;


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
}
