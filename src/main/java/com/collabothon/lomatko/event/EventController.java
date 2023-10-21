package com.collabothon.lomatko.event;

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

    @PostMapping(value = "/{eventId}/{customerId}")
    public HttpStatus joinEvent(@PathVariable Long eventId, @PathVariable Long customerId) {
        eventService.joinEvent(customerId, eventId);
        return HttpStatus.NO_CONTENT;
    }

    @DeleteMapping(value = "/{eventId}/{customerId}")
    public HttpStatus leaveEvent(@PathVariable Long eventId, @PathVariable Long customerId) {
        eventService.leaveEvent(customerId, eventId);
        return HttpStatus.NO_CONTENT;
    }
}
