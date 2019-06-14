package com.gmail.dissa.vadim.superkid.repository;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class SalesRepositoryTest extends AbstractSuperkidSystemTest {
    @Autowired
    private SalesRepository salesRepository;

    @Test
    public void testFindByOrderId() {
        assertEquals(0, salesRepository.findAll().size());
    }
}
