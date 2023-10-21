package com.collabothon.lomatko.organization;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


//
//    @PostMapping("/add")
//    public HttpStatus addOrganization(@RequestBody OrganizationEntity organizationEntity) {
//        service.addOrganization(organizationEntity);
//        return HttpStatus.OK;
//    }
//
//    @GetMapping(value = "/get/{id}", produces = "application/json")
//    public OrganizationEntity getOrganization(@PathVariable long id) {
//        return service.findById(id);
//    }

}
