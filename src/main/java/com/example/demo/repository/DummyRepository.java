package com.example.demo.repository;

import com.example.demo.domain.Dummy;

import java.time.LocalDate;
import java.util.List;

public interface DummyRepository {

    List<Dummy> findAll();
    List<Dummy> findDummiesCreatedAtSpecificDay(LocalDate localDate);
}
