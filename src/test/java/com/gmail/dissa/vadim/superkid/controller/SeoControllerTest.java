package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SeoControllerTest extends AbstractSuperkidSystemTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testResponseCodeRobotsTxt() throws Exception {
        mockMvc.perform(get("/robots.txt/")).andExpect(status().isOk());
    }

    @Test
    public void testModelAndViewInRobotsTxtMethod() {
        SeoController seoController = new SeoController();
        String response = seoController.getRobotsTxt();
        assertNotNull(response);
    }

    @Test
    public void testResponseCodeAndResponseTypeSiteMapXml() throws Exception {
        mockMvc.perform(get("/sitemap.xml/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/xml;charset=UTF-8"));
    }

    @Test
    public void testModelAndViewInSiteMapXmlMethod() {
        SeoController seoController = new SeoController();
        String response = seoController.getRobotsTxt();
        assertNotNull(response);
    }
}
