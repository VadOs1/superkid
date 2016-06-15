package com.gmail.dissa.vadim.superkid.repository;

import com.gmail.dissa.vadim.superkid.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
