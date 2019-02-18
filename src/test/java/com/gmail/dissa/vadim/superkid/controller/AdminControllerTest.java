package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.service.CRMService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class AdminControllerTest {
    private MockMvc mockMvc;
    private CRMService crmService;

    @Before
    public void setup() {
        crmService = mock(CRMService.class);
        when(crmService.getAuthenticatedUserName()).thenReturn("admin");
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
    public void testModelAndViewInAdminMethod() {
        AdminController adminController = new AdminController(crmService);
        ModelAndView modelAndView = adminController.admin(new ModelAndView());
        assertEquals("admin_index", modelAndView.getViewName());
        assertEquals("admin", modelAndView.getModel().get("userName"));
    }
}