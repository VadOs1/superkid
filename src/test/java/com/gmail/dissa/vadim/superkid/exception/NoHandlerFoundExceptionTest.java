package com.gmail.dissa.vadim.superkid.exception;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class NoHandlerFoundExceptionTest extends AbstractSuperkidSystemTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNoHandlerFoundException() throws Exception {
        mockMvc.perform(get("/LinkDoesNotExist"))
                .andExpect(status().isNotFound());
    }
}
