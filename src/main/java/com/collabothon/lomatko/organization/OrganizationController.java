package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.event.Event;
import com.collabothon.lomatko.event.EventDto;
import com.collabothon.lomatko.event.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationServiceImp service;

    @GetMapping(produces = "application/json")
    public List<OrganizationDto> getAll() {
        return OrganizationDtoMapper.INSTANCE.map(service.getAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public OrganizationDto getOrganization(@PathVariable long id) {
        return OrganizationDtoMapper.INSTANCE.mapToOrganizationDto(service.findById(id));
    }

    @GetMapping(value = "/{id}/events", produces = "application/json")
    public List<EventDto> getEvents(@PathVariable long id) {
        return EventDtoMapper.INSTANCE.mapToEventDtos(service.getEvents(id));
    }

    @GetMapping(value = "/time")
    public Long getTotalTime(){
        return service.getTotalVolunteerTimeByBank();
    }

    @GetMapping(value = "/{id}/time")
    public Long getOrganizationTime(@PathVariable long id){
        return service.getTotalVolunteerTimeByOrganization(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addOrganization(@RequestBody OrganizationDto organizationDto) {
        try {
            service.addOrganization(organizationDto);
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteOrganization (@PathVariable long id) {
        try {
            service.deleteOrganization(id);
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    @PostMapping(value = "/{organizationId}/{eventId}/confirm", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus confirmEvent (
            @PathVariable long organizationId,
            @PathVariable long eventId) {
        try {
            service.confirmEvent(organizationId, eventId);
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.NO_CONTENT;
    }

    @PostMapping(value = "/{organizationId}/event", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addEvent(@PathVariable Long organizationId, @RequestBody EventDto eventDto) {
        Event event = EventDtoMapper.INSTANCE.mapToEvent(eventDto);
        service.addEvent(organizationId, event);
        return HttpStatus.NO_CONTENT;
    }
}
