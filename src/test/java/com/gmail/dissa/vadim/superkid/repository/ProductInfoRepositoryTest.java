package com.gmail.dissa.vadim.superkid.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Before
    public void setup() {
        System.setProperty("file.encoding", "UTF-8");
    }

    @Test
    public void testFindByArticle() {
        String productInfoPhotoLinkShortExpected = productInfoRepository.findByArticle("300101").getPhotoLinkShort();
        assertEquals(productInfoPhotoLinkShortExpected, "img/kids/preview/01blue185X185.png");
    }
}
