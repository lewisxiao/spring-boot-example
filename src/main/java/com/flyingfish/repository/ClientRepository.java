package com.flyingfish.repository;

import com.flyingfish.infrastructure.authentication.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByClientId(String clientId);
}
