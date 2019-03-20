package com.example.demo.service;

import com.example.demo.domain.Dummy;
import com.example.demo.dto.WhateverDTO;
import com.example.demo.mapper.DummyMapper;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DummyMapperTest {

    private DummyMapper dummyMapper;

    @Before
    public void setUp() {
        dummyMapper = new DummyMapper();
    }

    @Test
    public void isEqualToFieldsByField() {
        // given
        Dummy dummy = new Dummy(1L,"some name");

        // when
        WhateverDTO result = dummyMapper.map(dummy);

        // then
        assertThat(result).isEqualToIgnoringGivenFields(dummy, "id");
    }
}