package com.gmail.dissa.vadim.superkid.repository;

import com.gmail.dissa.vadim.superkid.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
