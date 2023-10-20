package com.collabothon.lomatko.organization;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private OrganizationService service;

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<OrganizationEntity> getAll() {
        return service.getAll();
    }

    @PostMapping("/add")
    public HttpStatus addOrganization(@RequestBody OrganizationDto organizationDto) {
        service.addOrganization(organizationDto);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    public OrganizationEntity getOrganization (@PathVariable long id){
        return service.findById(id);
    }

}
