package com.collabothon.lomatko.event;

import com.collabothon.lomatko.organization.OrganizationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping(produces = "application/json")
    public List<EventDto> getAllEvents() {
        return EventDtoMapper.INSTANCE.mapToEventDtos(eventService.getAllEvents());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public EventDto addEvent(@RequestBody EventDto eventDto) {
        //TODO:: add logic
        return null;
    }

}
