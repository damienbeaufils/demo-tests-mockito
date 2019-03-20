package com.example.demo.mapper;

import com.example.demo.domain.Dummy;
import com.example.demo.dto.WhateverDTO;
import org.springframework.stereotype.Component;

@Component
public class DummyMapper {

    public WhateverDTO map(Dummy dummy) {
        return WhateverDTO.builder().name(dummy.getName()).build();
    }
}
