package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VolunteerMapper {
    VolunteerMapper INSTANCE = Mappers.getMapper(VolunteerMapper.class);

    Volunteer mapToVolunteer(CustomerEntity customerEntity);

    List<Volunteer> mapToVolunteers(List<CustomerEntity> customerEntities);

}
