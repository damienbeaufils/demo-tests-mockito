package com.example.demo.service;

import com.example.demo.domain.Dummy;
import com.example.demo.exception.DummyServiceException;
import com.example.demo.repository.DummyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {

    private final DummyRepository dummyRepository;

    public DummyServiceImpl(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    @Override
    public String doSomething(LocalDate localDate) {
        try {
            List<Dummy> dummies = dummyRepository.findAll();
            return "service called at " + localDate + " with result from repository " + dummies;
        } catch (RuntimeException e) {
            throw new DummyServiceException("error when doing something, please call 911", e);
        }
    }

    @Override
    public String doSomethingElse(LocalDate localDate) {
        try {
            LocalDate yesterday = localDate.minusDays(1);
            List<Dummy> dummies = dummyRepository.findDummiesCreatedAtSpecificDay(yesterday);
            return "dummies created at " + yesterday + ": " + dummies;
        } catch (RuntimeException e) {
            throw new DummyServiceException("error when doing something, please call 911", e);
        }
    }
}
