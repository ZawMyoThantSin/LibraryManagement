package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.models.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface AccountDao {

    int save(Account account);

    List<Account> getAll();

    int update(Account account);

    Account getById(int id);

    int delete(int id);

    Account validate(String username,String password);
}