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

    @GetMapping(produces = "application/json")
    public List<OrganizationDto> getAll() {
        return OrganizationDtoMapper.INSTANCE.map(service.getAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public OrganizationDto getOrganization(@PathVariable long id) {
        return OrganizationDtoMapper.INSTANCE.mapToOrganizationDto(service.findById(id));
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

}
