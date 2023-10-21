package com.collabothon.lomatko.organization;

import com.collabothon.lomatko.customer.CustomerEntity;
import com.collabothon.lomatko.event.EventEntity;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrganizationMapperTest {

    @Test
    void shouldMapObject() {

        List<CustomerEntity> customerEntities = Collections.singletonList(
                CustomerEntity.builder()
                        .id(11L)
                        .name("cust1")
                        .build()
        );

        List<EventEntity> eventEntities = Collections.singletonList(
                EventEntity.builder()
                        .spots(10)
                        .description("desc")
                        .title("title1")
                        .volunteers(customerEntities)
                        .build()
        );

        OrganizationEntity input = OrganizationEntity.builder()
                .id(1L)
                .name("name_organization")
                .description("description_organization")
                .events(eventEntities)
                .build();

        Organization organization = OrganizationMapper.INSTANCE.mapToOrganization(input);

        assertNotNull(organization);
        assertEquals("name_organization", organization.getName());
        assertEquals("description_organization", organization.getDescription());
        assertEquals(10, organization.getEvents().get(0).getSpots());
        assertEquals("cust1", organization.getEvents().get(0).getVolunteers().get(0).getName());

    }
}
