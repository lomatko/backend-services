package com.collabothon.lomatko.event;

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
}
