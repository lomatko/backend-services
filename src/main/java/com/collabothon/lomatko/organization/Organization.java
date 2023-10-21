package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.event.Event;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Organization {
    private Long id;
    private String name;
    private String description;
    private List<Event> events;
}
