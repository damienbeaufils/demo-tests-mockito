package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DummyControllerTestWithAutoConfigureMockMvc {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_on_do_something_endpoint_should_return_something_in_body() throws Exception {
        // when
        ResultActions resultActions = mockMvc.perform(get("/dummy/doSomething"));

        // then
        resultActions.andExpect(status().isOk())
                .andExpect(content().string("service called at 2019-04-12 with result from repository [Dummy(id=1, name=abc), Dummy(id=2, name=def)]"));
    }
}