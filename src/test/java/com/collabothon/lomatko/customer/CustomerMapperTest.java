package com.collabothon.lomatko.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    @Test
    void shouldMap() {
        CustomerEntity input = CustomerEntity.builder()
                .name("sample name")
                .id(1L)
                .build();

        Customer result = CustomerMapper.INSTANCE.mapToCustomer(input);

        assertNotNull(result);
        assertEquals("sample name", result.getName());
    }

}