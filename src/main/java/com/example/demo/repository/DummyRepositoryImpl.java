package com.example.demo.repository;

import com.example.demo.domain.Dummy;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class DummyRepositoryImpl implements DummyRepository {
    @Override
    public List<Dummy> findAll() {
        return Arrays.asList(new Dummy(1L, "abc"), new Dummy(2L,"def"));
    }

    @Override
    public List<Dummy> findDummiesCreatedAtSpecificDay(LocalDate localDate) {
        return Collections.emptyList();
    }
}
