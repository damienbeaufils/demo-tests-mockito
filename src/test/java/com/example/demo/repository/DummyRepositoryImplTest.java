package com.example.demo.repository;

import com.example.demo.domain.Dummy;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DummyRepositoryImplTest {

    private DummyRepository dummyRepository;

    @Before
    public void setUp() {
        dummyRepository = new DummyRepositoryImpl();
    }

    @Test
    public void extracting() {
        // when
        List<Dummy> result = dummyRepository.findAll();

        // then
        assertThat(result).extracting(Dummy::getName).containsExactly("abc", "def");
    }
}