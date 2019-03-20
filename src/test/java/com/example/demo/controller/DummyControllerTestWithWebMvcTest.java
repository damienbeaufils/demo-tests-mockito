package com.example.demo.controller;

import com.example.demo.service.DummyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DummyController.class)
public class DummyControllerTestWithWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DummyService dummyService;

    @Test
    public void get_on_do_something_endpoint_should_return_something_in_body() throws Exception {
        // given
        when(dummyService.doSomething(any(LocalDate.class))).thenReturn("some result from service");

        // when
        ResultActions resultActions = mockMvc.perform(get("/dummy/doSomething"));

        // then
        resultActions.andExpect(status().isOk())
                .andExpect(content().string("some result from service"));
    }
}