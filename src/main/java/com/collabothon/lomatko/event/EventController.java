package com.collabothon.lomatko.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
