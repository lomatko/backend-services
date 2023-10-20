package com.collabothon.lomatko.organization;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private final OrganizationRepository repository

    @GetMapping("/getAll")
    public List<OrganizationEntity> getAll () {
        return this.repository.findAll();
    }

    @GetMapping("/get/{organization}")
    public OrganizationDto getOrganization (@PathVariable String organization){
        OrganizationDto organizationDto = new OrganizationDto();
        //TODO: add functionality of getting record from DB
        return organizationDto;
    }

    @PostMapping("/add")
    public HttpStatus addOrganization(
            @RequestBody String name,
            @RequestBody String description) {

        //TODO: add functionality of adding record to DB
        return HttpStatus.OK;
    }
}
