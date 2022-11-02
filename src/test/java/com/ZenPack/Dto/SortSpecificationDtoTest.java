package com.ZenPack.Dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SortSpecificationDtoTest {

    @Test
    void testConstructor() {
        SortSpecificationDto actualSortSpecificationDto = new SortSpecificationDto();
        actualSortSpecificationDto.setColId("42");
        actualSortSpecificationDto.setSort("Sort");
        assertEquals("42", actualSortSpecificationDto.getColId());
        assertEquals("Sort", actualSortSpecificationDto.getSort());
    }
}

