package com.gmail.dissa.vadim.superkid.repository;

import com.gmail.dissa.vadim.superkid.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    public List<Sales> findByOrderId(long id);
}
