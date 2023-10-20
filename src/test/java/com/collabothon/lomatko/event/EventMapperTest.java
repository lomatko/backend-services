package com.collabothon.lomatko.event;

import com.collabothon.lomatko.customer.CustomerEntity;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventMapperTest {

    @Test
    void shouldMap() {
        List<CustomerEntity> customerEntities = Collections.singletonList(
                CustomerEntity.builder()
                        .id(11L)
                        .name("cust1")
                        .build()
        );

        EventEntity eventEntity = EventEntity.builder()
                .spots(10)
                .description("desc")
                .title("title1")
                .volunteers(customerEntities)
                .build();

        Event event = EventMapper.INSTANCE.mapToEvent(eventEntity);
        assertNotNull(event);
        assertEquals(10, event.getSpots());
        assertNotNull(event.getVolunteers());
        assertEquals(1, event.getVolunteers().size());
        assertEquals("cust1", event.getVolunteers().get(0).getName());
    }

}