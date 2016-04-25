package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.config.RootConfig;
import com.gmail.dissa.vadim.superkid.config.WebConfig;
import com.gmail.dissa.vadim.superkid.service.CRMService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class AdminControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    CRMService crmService;

    @Before
    public void setup() {
        crmService = mock(CRMService.class);
        when(crmService.getAuthentificatedUserName()).thenReturn("admin");
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AdminController(crmService)).build();
    }

    @Test
    public void testResponseCodeAndViewNameAndModelAttributesInAdminMethod() throws Exception {
        mockMvc.perform(get("/admin/")).andExpect(status().isOk())
                .andExpect(view().name("admin_index"))
                .andExpect(model().attribute("userName", "admin"))
                .andExpect(model().hasNoErrors());
    }

    @Test
    public void testModelAndViewInAdminMethod() throws Exception {
        AdminController adminController = new AdminController(crmService);
        ModelAndView modelAndView = adminController.admin(new ModelAndView());
        assertEquals("admin_index", modelAndView.getViewName());
        assertEquals("admin", modelAndView.getModel().get("userName"));
    }
}