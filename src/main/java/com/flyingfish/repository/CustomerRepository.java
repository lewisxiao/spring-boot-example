package com.flyingfish.repository;

import com.flyingfish.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Modifying
    @Query(value = "truncate table customer", nativeQuery = true)
    @Transactional
    void clear();
}
