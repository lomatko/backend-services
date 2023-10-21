package com.collabothon.lomatko.organization;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationServiceImp service;
    private final OrganizationRepository repository;

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<OrganizationDto> getAll() {
        return OrganizationDtoMapper.INSTANCE.map(service.getAll());
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    public OrganizationDto getOrganization(@PathVariable long id) {
        return OrganizationDtoMapper.INSTANCE.mapToOrganizationDto(service.findById(id));
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addOrganization(@RequestBody OrganizationDto organizationDto) {
        try {
            service.addOrganization(organizationDto);
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }


}
