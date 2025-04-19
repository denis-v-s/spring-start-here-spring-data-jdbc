package com.example.spring_data_jdbc.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.spring_data_jdbc.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    // This interface will automatically provide CRUD operations for the Account entity
    // No need to implement any methods here, Spring Data JPA will handle it for you

    // Using @Query improves readability and performance
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    // We have to use @Modifying because we are modifying the database
    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);
}
