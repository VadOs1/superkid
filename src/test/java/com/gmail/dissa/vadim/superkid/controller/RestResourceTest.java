package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import com.gmail.dissa.vadim.superkid.domain.ProductInfo;
import com.gmail.dissa.vadim.superkid.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestResourceTest extends AbstractSuperkidSystemTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testResponseCodeAndResponseTypeInRestMethod() throws Exception {
        mockMvc.perform(get("/rest?article=300101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("\"300101")));
    }

    @Test
    public void testModelAndViewInRestMethod() {
        ProductService productService = mock(ProductService.class);
        RestResource restResource = new RestResource(productService);
        ProductInfo productInfoActual = new ProductInfo();
        productInfoActual.setArticle("300101");
        when(productService.findProductInfoByArticle("300101")).thenReturn(productInfoActual);
        ProductInfo productInfoExpected = restResource.getProductInfo("300101");
        assertEquals(productInfoExpected, productInfoActual);
    }
}
