package com.gmail.dissa.vadim.superkid.repository;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ProductInfoRepositoryTest extends AbstractSuperkidSystemTest {
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
