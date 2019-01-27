package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.config.RootConfig;
import com.gmail.dissa.vadim.superkid.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class SeoControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testResponseCodeRobotsTxt() throws Exception{
        mockMvc.perform(get("/robots.txt/")).andExpect(status().isOk());
    }

    @Test
    public void testModelAndViewInRobotsTxtMethod() {
        SeoController seoController = new SeoController();
        String response = seoController.getRobotsTxt();
        assertNotNull(response);
    }

    @Test
    public void testResponseCodeAndResponseTypeSiteMapXml() throws Exception{
        mockMvc.perform(get("/sitemap.xml/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/xml"));
    }

    @Test
    public void testModelAndViewInSiteMapXmlMethod() {
        SeoController seoController = new SeoController();
        String response = seoController.getRobotsTxt();
        assertNotNull(response);
    }
}
