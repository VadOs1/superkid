package com.gmail.dissa.vadim.superkid.repository;


import com.gmail.dissa.vadim.superkid.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}
