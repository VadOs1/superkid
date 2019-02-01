package com.gmail.dissa.vadim.superkid.repository;

import com.gmail.dissa.vadim.superkid.config.MailConfig;
import com.gmail.dissa.vadim.superkid.config.RootConfig;
import com.gmail.dissa.vadim.superkid.config.WebConfig;
import com.gmail.dissa.vadim.superkid.domain.Sales;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = MailConfig.class),
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class SalesRepositoryTest {
    @Autowired
    private SalesRepository salesRepository;

    @Test
    public void testFindByOrderId() {
        List<Sales> sales = salesRepository.findByOrderId(1);
        assertEquals(sales.get(0).getOrder().getId(), 1);
        assertEquals(sales.get(1).getOrder().getId(), 1);
        assertEquals(sales.get(0).getProduct().getId(), 1);
        assertEquals(sales.get(1).getProduct().getId(), 2);
        assertEquals((int) sales.get(0).getPrice(), 100);
        assertEquals((int) sales.get(1).getPrice(), 200);
    }
}
