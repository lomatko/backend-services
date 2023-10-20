package com.collabothon.lomatko.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
    List<OrganizationEntity> findAll();
    void save(OrganizationDto dto);

}
