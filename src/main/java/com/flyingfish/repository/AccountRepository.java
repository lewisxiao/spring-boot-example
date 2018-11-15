package com.flyingfish.repository;

import com.flyingfish.entity.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Modifying
    @Query(value = "truncate table customer", nativeQuery = true)
    @Transactional
    void clear();

    Account findByUsernameEquals(String username);
}
