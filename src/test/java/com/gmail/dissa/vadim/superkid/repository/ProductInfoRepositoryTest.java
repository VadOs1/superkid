package com.gmail.dissa.vadim.superkid.repository;

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

import static org.junit.Assert.assertEquals;

@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Before
    public void setup() {
        System.setProperty("file.encoding", "UTF-8");
    }

    @Test
    public void testFindByArticle() {
        String productInfoPhotolinkShortExpected = productInfoRepository.findByArticle("300101").getPhotoLinkShort();
        assertEquals(productInfoPhotolinkShortExpected, "link_short_1");
    }

}
