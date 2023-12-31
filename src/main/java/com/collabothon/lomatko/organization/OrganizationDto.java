package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.event.EventDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrganizationDto {
    private Long id;
    private String name;
    private String description;
    private List<EventDto> events;
}
