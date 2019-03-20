package com.example.demo.controller;

import com.example.demo.service.DummyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DummyController {

    private final DummyService dummyService;

    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping("/dummy/doSomething")
    public ResponseEntity<String> doSomething() {
        String result = dummyService.doSomething(LocalDate.now());
        return ResponseEntity.ok(result);
    }
}
