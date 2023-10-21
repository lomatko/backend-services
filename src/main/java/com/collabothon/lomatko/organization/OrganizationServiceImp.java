package com.collabothon.lomatko.organization;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImp implements OrganizationService{

    private final OrganizationRepository repository;

    @Override
    public List<Organization> getAll() {
        return OrganizationMapper.INSTANCE.map(repository.findAll());
    }


//    public List<OrganizationDto> getAll() {
//
//    }

//    public void addOrganization(OrganizationEntity organizationEntity) {
//        repository.save(organizationEntity);
//    }
//
//    public OrganizationEntity findById(long id) {
//        return repository.findById(id).orElse(null);
//    }

}
